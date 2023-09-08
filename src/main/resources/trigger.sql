-- Eliminar trigger
DO $$BEGIN
    IF EXISTS (
        SELECT 1
        FROM pg_trigger
        WHERE tgname = 'user_notification_by_role_insert_trigger'
    ) THEN
        DROP TRIGGER user_notification_by_role_insert_trigger ON notification;
    END IF;
END$$;

DO $$
    BEGIN
        IF EXISTS (
            SELECT 1
            FROM pg_trigger
            WHERE tgname = 'count_number_order_trigger'
        ) THEN
            DROP TRIGGER count_number_order_trigger ON orders;
        END IF;
    END $$;

DO $$BEGIN
    IF EXISTS (
        SELECT 1
        FROM pg_trigger
        WHERE tgname = 'update_table_reserved_trigger'
    ) THEN
        DROP TRIGGER update_table_reserved_trigger ON tables;
    END IF;
END$$;
DO $$BEGIN
    IF EXISTS (
        SELECT 1
        FROM pg_trigger
        WHERE tgname = 'update_table_on_order_completion_trigger'
    ) THEN
        DROP TRIGGER update_table_on_order_completion_trigger ON tables;
    END IF;
END$$;
DO $$BEGIN
    IF EXISTS (
        SELECT 1
        FROM pg_trigger
        WHERE tgname = 'close_inventory_trigger'
    ) THEN
        DROP TRIGGER close_inventory_trigger ON tables;
    END IF;
END$$;
DO $$BEGIN
    IF EXISTS (
        SELECT 1
        FROM pg_trigger
        WHERE tgname = 'insert_inventory_detail_trigger'
    ) THEN
        DROP TRIGGER insert_inventory_detail_trigger ON tables;
    END IF;
END$$;
DO $$BEGIN
    IF EXISTS (
        SELECT 1
        FROM pg_trigger
        WHERE tgname = 'update_before_inventory'
    ) THEN
        DROP TRIGGER update_before_inventory ON inventory;
    END IF;
END$$;

-- Crear la funcion

CREATE OR REPLACE FUNCTION user_notification_by_role_insert_trigger()
    RETURNS TRIGGER AS $$
DECLARE
    role_ids varchar[];
BEGIN
    role_ids := NEW.roles;

    INSERT INTO user_notification (user_id, notification_id, status)
    SELECT DISTINCT u.id, NEW.id, false
    FROM users u
             INNER JOIN role ur ON u.role_id = ur.id
    WHERE ur.name = ANY(NEW.roles);


    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION count_number_order_trigger()
    RETURNS TRIGGER AS $$
DECLARE
    today DATE;
    order_count INT;
BEGIN
    today := current_date;
    SELECT COUNT(*) INTO order_count
    FROM orders
    WHERE create_at::DATE = today;

    order_count := order_count + 1;
    NEW.number_order := order_count;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_table_reserved_trigger()
    RETURNS TRIGGER AS $$
BEGIN
    UPDATE tables
    SET available = false
    WHERE id = NEW.table_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_table_on_order_completion_trigger()
    RETURNS TRIGGER AS $$
DECLARE
    state INT;
BEGIN

    SELECT id INTO state FROM order_states WHERE name = 'Completado';

    IF NEW.state_id = state THEN

        UPDATE tables
        SET available = true
        WHERE id = NEW.table_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION close_inventory_trigger()
    RETURNS TRIGGER AS $$
BEGIN
    UPDATE inventory SET is_active = false, update_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insert_inventory_detail_trigger()
    RETURNS TRIGGER AS $$
DECLARE ultimo_id INTEGER;
BEGIN
    SELECT id INTO ultimo_id  FROM Inventory WHERE is_active = false  ORDER BY id DESC  LIMIT 1;

    IF ultimo_id IS NOT NULL THEN
        INSERT INTO Inventory_Detail (inventory_id, ingredient_id, quantity, price, is_entry,create_at)
        SELECT NEW.id, ingredient_id, SUM(CASE WHEN is_entry THEN sum_q ELSE -sum_q END) as quantity, sum(average_price*sum_q) / sum(sum_q) as price, true,now()
        FROM (
                 SELECT is_entry, ingredient_id, sum(quantity) as sum_q, sum(price*quantity) / sum(quantity) as average_price
                 FROM Inventory_Detail
                 WHERE inventory_id = ultimo_id
                 GROUP BY is_entry, ingredient_id
             ) AS subquery
        GROUP BY ingredient_id;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insert_inventory_detail_function(new_order BIGINT)
    RETURNS VOID AS $$
DECLARE
    last_id INTEGER;
BEGIN
    SELECT id INTO last_id
    FROM Inventory
    WHERE is_active = true
    ORDER BY id DESC
    LIMIT 1;
    INSERT INTO Inventory_Detail (inventory_id, ingredient_id, quantity, price, is_entry, create_at)
    SELECT last_id AS inventory_id,
           d.ingredient_id,
           SUM(i.quantity * od.quantity) AS quantity,
           SUM(d.price * i.quantity * od.quantity) / SUM(i.quantity * od.quantity) AS price,
           false AS is_entry,
           NOW() AS create_at
    FROM orders o
             INNER JOIN order_details od ON o.id = od.order_id and o.id=new_order
             INNER JOIN products p ON p.id = od.product_id
             INNER JOIN ingredient_detail i ON p.id = i.product_id
             INNER JOIN ingredient ing ON i.ingredient_id = ing.id AND ing.is_countable = TRUE
             INNER JOIN inventory_detail d ON i.ingredient_id = d.ingredient_id AND d.inventory_id = last_id
    WHERE last_id IS NOT NULL
    GROUP BY d.ingredient_id;

    RETURN;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_inventory_details(inventory_id_param BIGINT)
    RETURNS TABLE (
                      id BIGINT,
                      inventoryId BIGINT,
                      quantity double precision,
                      price double precision,
                      ingredientId BIGINT,
                      ingredientName varchar
                  ) AS $$
BEGIN
    RETURN QUERY
        SELECT
            inv_detail.ID,
            inv_detail.inventory_id as inventoryId,
            subquery.quantity AS quantity,
            subquery.price AS price,
            subquery.ingredient_id AS ingredientId,
            ingredient.name AS ingredientName
        FROM Inventory_Detail inv_detail
                 INNER JOIN (
            SELECT
                sub.inventory_id,
                sub.ingredient_id,
                SUM(CASE WHEN sub.is_entry THEN sub.quantity ELSE -sub.quantity END) AS quantity,
                SUM(CASE WHEN sub.is_entry THEN sub.price*sub.quantity ELSE -sub.price*sub.quantity END) / SUM(CASE WHEN sub.is_entry THEN sub.quantity ELSE -sub.quantity END) AS price
            FROM Inventory_Detail sub
            WHERE sub.inventory_id = inventory_id_param
            GROUP BY sub.inventory_id, sub.ingredient_id
        ) AS subquery
                            ON inv_detail.inventory_id = subquery.inventory_id
                                AND inv_detail.ingredient_id = subquery.ingredient_id
                 INNER JOIN Ingredient ingredient
                            ON inv_detail.ingredient_id = ingredient.id;

    RETURN;
END;
$$ LANGUAGE plpgsql;

-- crear trigger

CREATE TRIGGER user_notification_by_role_insert_trigger
    AFTER INSERT ON notification
    FOR EACH ROW
EXECUTE FUNCTION user_notification_by_role_insert_trigger();

CREATE TRIGGER before_insert_order
    BEFORE INSERT ON orders
    FOR EACH ROW
EXECUTE FUNCTION count_number_order_trigger();

CREATE TRIGGER update_table_reserved_trigger
    AFTER INSERT ON orders
    FOR EACH ROW
EXECUTE FUNCTION update_table_reserved_trigger();

CREATE TRIGGER update_table_on_order_completion_trigger
    AFTER UPDATE ON orders
    FOR EACH ROW
    WHEN (OLD.state_id IS DISTINCT FROM NEW.state_id)
EXECUTE FUNCTION update_table_on_order_completion_trigger();

CREATE TRIGGER close_inventory_trigger
    BEFORE INSERT
    ON inventory
    FOR EACH ROW
EXECUTE FUNCTION close_inventory_trigger();

CREATE TRIGGER insert_inventory_detail_trigger
    AFTER INSERT
    ON Inventory
    FOR EACH ROW
EXECUTE FUNCTION insert_inventory_detail_trigger();
