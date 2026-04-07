package edu.itm.SistemaDeInventario.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Connection con;

    public Connection getCon() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/inventario_db?serverTimezone=UTC",
                    "root",
                    "root"); //datos de la database
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.printStackTrace();
        }
        return con;
    }
//ejemplo de conexion del profesor:
//    public static void main(String[] args) {
//        Conexion conection = new Conexion();
//        try {
//            ResultSet r = conection.obtenerConexion().prepareStatement("select * from estudiante").executeQuery();
//            if (r.next()) {
//                System.out.println("id: " + r.getString(1) + " nombre: " + r.getString(2));
//                while (r.next()) {
//                    System.out.println("cedula: " + r.getString("cedula") + "nombres: " + r.getString("nombres"));
//                }
//            } else {
//                System.out.println("NO HAY DATOS");
//            }
//        } catch (Exception e) {
//            System.out.println("#Excepcion: " + e.getMessage());
//        }
//    }
}