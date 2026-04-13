package edu.itm.SistemaDeInventario.services;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;

import java.util.List;

public interface ProductoServicesInterface {

    List<Producto> findAll();

    Producto findById(int id);

    int save(Producto producto);

    int update(Producto producto);
    int delete(int id);
}
