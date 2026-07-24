/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bd272;

/**
 *
 * @author ESTRELLA
 */

import java.sql.*;

public class BD272 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
       
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" Driver cargado correctamente");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/BD2-272", 
                "root", 
                ""
            );
            System.out.println("Conectado a la base de datos");

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM DOCENTE");

            System.out.println("\n LISTA DE DOCENTES:");
            System.out.println("─".repeat(40));
            while (rs.next()) {
                int id = rs.getInt("docente_id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                System.out.println("ID: " + id + " | " + nombre + " | " + correo);
            }

        } catch (ClassNotFoundException e) {
            System.err.println(" Error: No se encontró el driver MySQL");
            System.err.println("   Verifica que el mysql-connector esté en el proyecto");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println(" Error de SQL: " + e.getMessage());
      
            e.printStackTrace();
            
        } finally {
           
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("\n Recursos cerrados correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
    