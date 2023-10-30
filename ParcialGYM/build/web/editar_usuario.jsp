<%-- 
    Document   : editar_usuario
    Created on : 21/10/2023, 8:12:23 p. m.
    Author     : juand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Clientes.Datoscliente"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GYM UD</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Bienvenido a GYM UD</h1>
    </header>
    <section class="formulario">
        <h2>Por favor, edita tus datos:</h2>
        <form id="frmActualizarDatos" method="POST" action="ActualizarDatos">
            <input type="hidden" id="txtId" name="txtId" value="<%= ((Datoscliente)session.getAttribute("usuarios")).getId() %>">
            <div class="input-container">
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre" id="nombre" value="<%= ((Datoscliente)session.getAttribute("usuarios")).getNombre() %>">
            </div>
            <div class="input-container">
                <label for="apellido">Apellido:</label>
                <input type="text" name="apellido" id="apellido" value="<%= ((Datoscliente)session.getAttribute("usuarios")).getApellido() %>">
            </div>
            <div class="input-container">
                <label for="correo">Correo electrónico:</label>
                <input type="email" name="correo" id="correo" value="<%= ((Datoscliente)session.getAttribute("usuarios")).getCorreo() %>" >
            </div>
            <div class="input-container">
                <label for="telefono">Teléfono:</label>
                <input type="tel" name="telefono" id="telefono" value="<%= ((Datoscliente)session.getAttribute("usuarios")).getCelular() %>">
            </div>
            <div class="input-container">
                <label for="peso">Peso (kg):</label>
                <input type="text" name="peso" id="peso" value="<%= ((Datoscliente)session.getAttribute("usuarios")).getPeso() %>">
            </div>
            <div class="input-container">
                <label for="estatura">Estatura (cm):</label>
                <input type="text" name="estatura" id="estatura" value="<%= ((Datoscliente)session.getAttribute("usuarios")).getEstatura() %>">
            </div>
            <div class="input-container">
                <input type="submit" value="Enviar" onclick="submit();">
            </div>
            
        </form>

    
    </section>
</body>
</html>


