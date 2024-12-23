CREATE TABLE temp_val(some_val bigint);

CREATE OR REPLACE PROCEDURE commitproc(a INOUT bigint) AS '
BEGIN
INSERT INTO temp_val values(a);
COMMIT;
END;' LANGUAGE plpgsql;
