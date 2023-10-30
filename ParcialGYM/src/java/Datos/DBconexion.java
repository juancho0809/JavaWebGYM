/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author juand
 */
public class DBconexion {
    
    static String bd = "dgym";
   
    
    static String login = "root";
    static String password = "";
    
    static String driver = "com.mysql.cj.jdbc.Driver";
    
    static String url = "jdbc:mysql://localhost/"+bd;
    static String mensaje = "fasfad";
    
    Connection conexion = null;
    /**
     * Constructor de la clase
     */
    public DBconexion() {
        try{
                Class.forName(driver);
                conexion = DriverManager.getConnection(url,login,password);
                System.out.println("hola");
                if (conexion!=null){
                        System.out.println("Conexión a base de datos "+bd+" OK");
                }
        }catch(SQLException e){
                System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }

    /**
     * metodo que desconecta la base de datos
     */
    public void desconectar(){
        conexion = null;
    }
    
    public static String getMensaje() {
        return mensaje;
    }

    /**
     * Metodo para setear mensajes de control
     * @param mensaje 
     */
    public static void setMensaje(String mensaje) {
        DBconexion.mensaje = mensaje;
    }
}
