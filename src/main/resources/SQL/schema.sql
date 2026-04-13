CREATE DATABASE IF NOT EXISTS inventario_db;

CREATE TABLE productos (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nomProducto VARCHAR(100),
    descripcionProducto VARCHAR(200),
    ingresoProducto DATE
);