/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Datos.*;
import Clientes.*;

/**
 *
 * @author juand
 */
public class CargaDato extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        Datoscliente dc = new Datoscliente();
        DBdatos conDB = new DBdatos();
        try {
            int conId = Integer.parseInt(request.getParameter("item"));
            String opc = request.getParameter("op");
            out.write(opc);
            ResultSet res = conDB.getContactoById(conId);
            
            if(res.next()){
                System.out.println("Llegue a cargar usuario");
                dc.setId(res.getInt("id"));
                dc.setNombre(res.getString("nombre"));
                dc.setApellido(res.getString("apellido"));
                dc.setCorreo(res.getString("correo"));
                dc.setCelular(res.getString("telefono"));
                dc.setEstatura(res.getString("alturacm"));
                dc.setPeso(res.getString("pesokg"));
            }
            
            if(opc.equals("edit")){
                request.getSession().setAttribute("usuarios", dc);
                response.sendRedirect("editar_usuario.jsp");
            }
            if(opc.equals("delete")){
                conDB.borrarContacto(dc);
                response.sendRedirect("Inicio");
            }
        }catch(Exception e){
            
        }finally {            
            out.close();
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
