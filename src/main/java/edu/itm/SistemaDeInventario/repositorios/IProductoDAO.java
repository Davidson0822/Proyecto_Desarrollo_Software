package edu.itm.SistemaDeInventario.repositorios;


import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import java.util.List;


     //Interfaz que define patrón DAO para la entidad Producto

    public interface IProductoDAO {

        //
        List<Producto> findAll();
        Producto findById(int id);

        //
        int save(Producto producto);
        int update(Producto producto);
        int delete(int id);
    }

