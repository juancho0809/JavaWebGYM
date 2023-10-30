/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.*;
//import java.sql.ResultSet;
import Clientes.*;

/**
 *
 * @author juand
 */
public class DBdatos {
    DBconexion cn;
    
    public DBdatos() {
        cn = new DBconexion();
    }

public ResultSet getContactoById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, "
                + " nombre,"
                + " apellido,"
                + " correo, "
                + " telefono,"
                + " alturacm,"
                + " pesokg "
                + " FROM usuarios"
                + " WHERE id = ? ");
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }

    public ResultSet getContactos() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, "
                + " nombre, "
                + " apellido, "
                + " correo, "
                + " telefono,"
                + " alturacm, "
                + " pesokg"
                + " FROM usuarios "
                + " ORDER BY nombre, apellido ");


        ResultSet res = pstm.executeQuery();
        return res;
    }

public void insertarContacto(Datoscliente dc) {
    try {
        PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO usuarios (nombre,"
                + " apellido,"
                + " correo, "
                + "telefono,"
                + " alturacm,"
                + " pesokg) "
                + "VALUES (?,?,?,?,?,?)");
        pstm.setString(1, dc.getNombre());
        pstm.setString(2, dc.getApellido());
        pstm.setString(3, dc.getCorreo());
        pstm.setString(4, dc.getCelular());
        pstm.setString(5, dc.getEstatura());
        pstm.setString(6, dc.getPeso());
        
        System.out.println("Hola");

        pstm.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }
}

public void actualizarContacto(Datoscliente dc) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update usuarios set nombre = ?, "
                    + " apellido = ?,"
                    + " correo = ?,"
                    + " telefono = ?,"
                    + " alturacm = ?,"
                    + " pesokg = ? "
                    + " where id = ?");
            pstm.setString(1, dc.getNombre());
            pstm.setString(2, dc.getApellido());
            pstm.setString(3, dc.getCorreo());
            pstm.setString(4, dc.getCelular());
            pstm.setString(5, dc.getEstatura());
            pstm.setString(6, dc.getPeso());
            pstm.setInt(7, dc.getId());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void borrarContacto(Datoscliente dc) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from usuarios "
                    + " where id = ?");

            pstm.setInt(1, dc.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public String getMensaje() {
        return DBconexion.getMensaje();
    }
}


