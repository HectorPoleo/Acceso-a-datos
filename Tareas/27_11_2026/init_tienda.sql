CREATE DATABASE IF NOT EXISTS tienda_callable;
USE tienda_callable;

DROP TABLE IF EXISTS productos;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    precio DOUBLE NOT NULL
);

INSERT INTO productos (nombre, precio) VALUES 
    ('Teclado Mecánico', 80.00), 
    ('Ratón Gaming', 45.00);

DROP PROCEDURE IF EXISTS aplicar_descuento;
CREATE PROCEDURE aplicar_descuento(
    IN p_id INT, 
    IN p_porcentaje DOUBLE, 
    OUT p_nuevo_precio DOUBLE
)
BEGIN
    UPDATE productos 
    SET precio = precio - (precio * p_porcentaje / 100) 
    WHERE id = p_id;
    
    SELECT precio INTO p_nuevo_precio FROM productos WHERE id = p_id;
END;

DROP FUNCTION IF EXISTS calcular_precio_iva;
CREATE FUNCTION calcular_precio_iva(p_id INT) 
RETURNS DOUBLE
DETERMINISTIC
BEGIN
    DECLARE v_precio DOUBLE;
    SELECT precio INTO v_precio FROM productos WHERE id = p_id;
    RETURN v_precio * 1.21;
END;