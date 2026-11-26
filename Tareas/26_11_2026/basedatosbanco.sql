CREATE DATABASE IF NOT EXISTS basebanco;
USE basebanco;

    CREATE TABLE IF NOT EXISTS cuenta(
        id INT AUTO_INCREMENT PRIMARY KEY,
        isbn VARCHAR(80) NOT NULL UNIQUE,
        titular VARCHAR(60),
        saldo DOUBLE NOT NULL
        );

    CREATE TABLE IF NOT EXISTS movimiento(
        id INT AUTO_INCREMENT PRIMARY KEY,
        id_cuenta_origen INT NOT NULL,
        id_cuenta_destino INT NOT NULL,
        concepto VARCHAR(60),
        FOREIGN KEY (id_cuenta_origen) REFERENCES cuenta(id),
        FOREIGN KEY (id_cuenta_destino) REFERENCES cuenta(id)
        );