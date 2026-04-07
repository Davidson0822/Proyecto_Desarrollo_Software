package edu.itm.SistemaDeInventario.repositorios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import edu.itm.SistemaDeInventario.utilities.Conexion;
import java.util.List;
import java.util.ArrayList;

public class ProductoDAOImpl implements IProductoDAO {

    private Conexion conexion = new Conexion();

    @Override
    public List<Producto> findAll() {

        return new ArrayList<>();
    }

    @Override
    public Producto findById(int id) {
        return null;
    }

    @Override
    public int save(Producto producto) { return 0; }

    @Override
    public int update(Producto producto) { return 0; }

    @Override
    public int delete(int id) { return 0; }
}