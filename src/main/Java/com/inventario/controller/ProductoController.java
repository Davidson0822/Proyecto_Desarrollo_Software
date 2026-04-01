package com.inventario.controller;

import com.inventario.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    public List<Producto> listar() {
        return productos;
    }

    public String crear(Producto producto) {
        productos.add(producto);
        return "Producto agregado";
    }

    public String eliminar(int id) {
        productos.removeIf(p -> p.getId() == id);
        return "Producto eliminado";
    }
}