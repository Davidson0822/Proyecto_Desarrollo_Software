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

    public Producto findById(int id){
        if (id > 0) {
            return repositorySQL.findById(id);
        } else {
            return null;
        }
    }

    public int save(Producto producto) {
        Producto existente = repositorySQL.findById(producto.getIdProducto());

        if(existente != null) {
            throw new RuntimeException("El ID producto ya existe");
        }

        return repositorySQL.save(producto);
    }

    public int update(Producto producto) {
        Producto existente = repositorySQL.findById(producto.getIdProducto());

        if (existente == null) {
            throw new RuntimeException("No se puede actualizar, el producto no existe");
        }

        return repositorySQL.update(producto);
    }

    public int delete(int id) {
        Producto existente = repositorySQL.findById(id);

        if (existente == null) {
            throw new RuntimeException("No se puede eliminar, el producto no existe");
        }

        return repositorySQL.delete(id);
    }

}
