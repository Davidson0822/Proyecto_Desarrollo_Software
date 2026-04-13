package edu.itm.SistemaDeInventario.services;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import edu.itm.SistemaDeInventario.repositorios.IProductoDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServices implements ProductoServicesInterface
{
    private final IProductoDAO repositorySQL;

    public ProductoServices(IProductoDAO repositorySQL) {this.repositorySQL = repositorySQL;}

    public List<Producto> findAll(){ return repositorySQL.findAll();};

    public Producto findById(int id){ if (id <= 0) {return repositorySQL.findById(id);} else {return null;}}

    public int save(Producto producto) {return repositorySQL.save(producto);}

    public int update(Producto producto) {return repositorySQL.update(producto);}

}
