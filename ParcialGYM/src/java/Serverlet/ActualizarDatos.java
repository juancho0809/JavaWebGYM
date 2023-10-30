/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlet;

import Clientes.Datoscliente;
import Datos.DBdatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juand
 */
@WebServlet(name = "ActualizarDatos", urlPatterns = {"/ActualizarDatos"})
public class ActualizarDatos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Datoscliente dc = new Datoscliente();
            DBdatos conDB = new DBdatos();
            /* TODO output your page here. You may use following sample code. */
            dc.setId(Integer.valueOf(request.getParameter("txtId")));
            dc.setNombre(request.getParameter("nombre"));

            dc.setApellido(request.getParameter("apellido"));
            if("".equals(dc.getApellido())){
                response.sendRedirect("insertarUsuario.html");
                return;
            }
            dc.setCorreo(request.getParameter("correo"));
            if("".equals(dc.getCorreo())){
                response.sendRedirect("insertarUsuario.html");
                return;
            }
            dc.setCelular(request.getParameter("telefono"));
            if("".equals(dc.getCelular())){
                response.sendRedirect("insertarUsuario.html");
                return;
            }
            dc.setPeso(request.getParameter("peso"));
            if("".equals(dc.getPeso())){
                response.sendRedirect("insertarUsuario.html");
                return;
            }
            dc.setEstatura(request.getParameter("estatura"));
            if("".equals(dc.getEstatura())){
                response.sendRedirect("insertarUsuario.html");
                return;
            }
            
            conDB.actualizarContacto(dc);
            response.sendRedirect("Inicio");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
