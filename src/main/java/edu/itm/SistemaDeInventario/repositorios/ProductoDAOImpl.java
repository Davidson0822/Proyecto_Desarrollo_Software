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
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = conexion.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNomProducto(rs.getString("nomProducto"));
                p.setDescripcionProducto(rs.getString("descripcionProducto"));
                p.setIngresoProducto(rs.getDate("ingresoProducto"));

                productos.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }
        return productos;
    }

    @Override
    public Producto findById(int id) {
        Producto p = null;
        String sql = "SELECT * FROM productos WHERE idProducto = ?";

        try (Connection con = conexion.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new Producto();
                    p.setIdProducto(rs.getInt("idProducto"));
                    p.setNomProducto(rs.getString("nomProducto"));
                    p.setDescripcionProducto(rs.getString("descripcionProducto"));
                    p.setIngresoProducto(rs.getDate("ingresoProducto"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar producto por ID: " + e.getMessage());
        }
        return p;
    }


    //TODO: implementar metodos de escritura y eliminacion (puntos 3 y 4)
    @Override
    public int save(Producto producto) { return 0; }

    @Override
    public int update(Producto producto) { return 0; }

    @Override
    public int delete(int id) { return 0; }
}