<%-- 
    Document   : VistaUsuarios
    Created on : 20/10/2023, 1:35:09 p. m.
    Author     : juand
--%>

<%@page import="java.util.List"%>
<%@page import="Clientes.Datoscliente"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet usuarios = (ResultSet)session.getAttribute("usuarios"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacion de Usuarios</title>
        <script src='validar.jsp' language='JavaScript1.2'></script>
        <link href='styles.css' rel='stylesheet' type='text/css'>
        
    </head>
    <body>
        <h1>Contactos</h1>
        <table>
            <tr>
                <th>codigo</th><th>nombre</th><th>apellido</th><th>correo</th><th>telefono</th><th>alturacm</th><th>pesokg</th><th>acciones</th>
            </tr>
            
                <!-- Iterar a través de los resultados -->
                <% while (usuarios.next()) { %>
                
                    <tr>
                        <td><%= usuarios.getString("id") %></td>
                        <td><%= usuarios.getString("nombre") %></td>
                        <td><%= usuarios.getString("apellido") %></td>
                        <td><%= usuarios.getString("correo") %></td>
                        <td><%= usuarios.getString("telefono") %></td>
                        <td><%= usuarios.getString("alturacm") %></td>
                        <td><%= usuarios.getString("pesokg") %></td>
                        <td class="links"><a href="CargaDato?op=edit&item=<%= usuarios.getString("id") %>">Editar</a></td>
                        <td class="links"><a href="CargaDato?op=delete&item=<%= usuarios.getString("id") %>">Borrar</a></td>
                        

                        
                    </tr>
                    
                
                    <!-- Código para mostrar los datos -->
                <% } %>
                <tr>
                    <td colspan="5" class="links"><a href="insertarUsuario.html">Volver al Registro</a></td>
                </tr>
            
            
                <!-- Código para manejar el caso en que usuarios es nulo -->
           

        </table>

    </body>
</html>
