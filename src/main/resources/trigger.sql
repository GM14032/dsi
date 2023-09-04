-- Eliminar trigger
DO $$BEGIN
    IF EXISTS (
        SELECT 1
        FROM pg_trigger
        WHERE tgname = 'user_notification_insert_trigger'
    ) THEN
        DROP TRIGGER user_notification_insert_trigger ON notification;
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
        WHERE tgname = 'update_table_create_order_trigger'
    ) THEN
DROP TRIGGER update_table_create_order_trigger ON tables;
END IF;
END$$;

-- Crear la funcion

CREATE OR REPLACE FUNCTION insert_user_notification_trigger()
RETURNS TRIGGER AS $$
DECLARE
    role_ids varchar[];
BEGIN
    role_ids := NEW.roles;

    FOR i IN 1..array_length(role_ids, 1) LOOP
        INSERT INTO user_notification (user_id, notification_id, status)
        SELECT DISTINCT u.id, NEW.id, false
        FROM users u
        INNER JOIN role ur ON u.role_id = ur.id
        WHERE ur.name = role_ids[i];
    END LOOP;

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

CREATE OR REPLACE FUNCTION update_table_create_order_trigger()
RETURNS TRIGGER AS $$
BEGIN
UPDATE tables
SET available = false
WHERE id = NEW.table_id;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_table_update_order_trigger()
    RETURNS TRIGGER AS $$
    DECLARE
      state INT;
    BEGIN

  SELECT id INTO state FROM order_states WHERE name = 'completado';

  IF NEW.state_id = state THEN

    UPDATE tables
    SET available = true
    WHERE id = NEW.table_id;
  END IF;
  RETURN NEW;
    END;
$$ LANGUAGE plpgsql;

-- crear trigger
CREATE TRIGGER user_notification_insert_trigger
AFTER INSERT ON notification
FOR EACH ROW
EXECUTE FUNCTION insert_user_notification_trigger();

CREATE TRIGGER before_insert_order
    BEFORE INSERT ON orders
    FOR EACH ROW
EXECUTE FUNCTION count_number_order_trigger();

CREATE TRIGGER update_table_create_order_trigger
    AFTER INSERT ON orders
    FOR EACH ROW
    EXECUTE FUNCTION update_table_create_order_trigger();

CREATE TRIGGER update_table_update_order_trigger
    AFTER UPDATE ON orders
    FOR EACH ROW
    WHEN (OLD.state_id IS DISTINCT FROM NEW.state_id)
EXECUTE FUNCTION update_table_update_order_trigger();
