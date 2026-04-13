CREATE DATABASE IF NOT EXISTS inventario_db;

CREATE TABLE productos (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nomProducto VARCHAR(100),
    desProducto VARCHAR(200),
    ingProducto DATE()
);