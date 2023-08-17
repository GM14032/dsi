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

-- Crear la funcion

CREATE OR REPLACE FUNCTION insert_user_notification_trigger()
RETURNS TRIGGER AS $$
DECLARE
    role_ids varchar[];
BEGIN
    role_ids := NEW.roles;

    FOR i IN 1..array_length(role_ids, 1) LOOP
        INSERT INTO user_notification (user_id, notification_id, status)
        SELECT DISTINCT u.id, NEW.id, 0
        FROM users u
        INNER JOIN role ur ON u.role_id = ur.id
        WHERE ur.name = role_ids[i];
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- crear trigger
CREATE TRIGGER user_notification_insert_trigger
AFTER INSERT ON notification
FOR EACH ROW
EXECUTE FUNCTION insert_user_notification_trigger();