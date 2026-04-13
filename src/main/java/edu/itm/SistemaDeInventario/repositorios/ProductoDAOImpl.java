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


    @Override
    public int save(Producto producto) {
        String sql = "INSERT INTO productos (nomProducto, descripcionProducto, ingresoProducto) VALUES (?, ?, ?)";
        try (Connection con = conexion.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNomProducto());
            ps.setString(2, producto.getDescripcionProducto());
            ps.setDate(3, new java.sql.Date(producto.getIngresoProducto().getTime()));

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al guardar producto: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int update(Producto producto) {
        if (producto.getIdProducto() <= 0) {
            System.err.println("ID inválido para actualizar.");
            return 0;
        }
        String sql = "UPDATE productos SET nomProducto = ?, descripcionProducto = ?, ingresoProducto = ? WHERE idProducto = ?";
        try (Connection con = conexion.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNomProducto());
            ps.setString(2, producto.getDescripcionProducto());
            ps.setDate(3, new java.sql.Date(producto.getIngresoProducto().getTime()));
            ps.setInt(4, producto.getIdProducto());

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        if (id <= 0) {
            System.err.println("ID inválido para eliminar.");
            return 0;
        }
        String sql = "DELETE FROM productos WHERE idProducto = ?";
        try (Connection con = conexion.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
            return 0;
        }
    }
}