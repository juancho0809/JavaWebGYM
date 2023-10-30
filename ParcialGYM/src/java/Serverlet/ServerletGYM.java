/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Clientes.*;
import Datos.*;


/**
 *
 * @author juand
 */
@WebServlet(name = "ServerletGYM", urlPatterns = {"/ServerletGYM"})
public class ServerletGYM extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            Datoscliente dc = new Datoscliente();
            DBdatos datosDB = new DBdatos();
            
          
            
            dc.setNombre(request.getParameter("nombre"));
            if("".equals(dc.getNombre())){
                response.sendRedirect("index.html");
                return;
            }
            dc.setApellido(request.getParameter("apellido"));
            if("".equals(dc.getApellido())){
                response.sendRedirect("index.html");
                return;
            }
            dc.setCorreo(request.getParameter("correo"));
            if("".equals(dc.getCorreo())){
                response.sendRedirect("index.html");
                return;
            }
            dc.setCelular(request.getParameter("telefono"));
            if("".equals(dc.getCelular())){
                response.sendRedirect("index.html");
                return;
            }
            dc.setPeso(request.getParameter("peso"));
            if("".equals(dc.getPeso())){
                response.sendRedirect("index.html");
                return;
            }
            dc.setEstatura(request.getParameter("estatura"));
            if("".equals(dc.getEstatura())){
                response.sendRedirect("index.html");
                return;
            }
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"styles.css\">");
            out.println("<title>Servlet ServerletGYM</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<section class=formulario>");
            out.println("<h1>Recopilación de Datos Cliente</h1>");
            out.println("Los datos registrados fueron: <br>");
            out.println("<br>Nombre: "+ dc.getNombre()+"<br>");
            out.println("<br>Apelldo: "+ dc.getApellido()+"<br>");
            out.println("<br>Correo Electronico: "+ dc.getCorreo()+"<br>");
            out.println("<br>Teléfono: "+ dc.getCelular()+"<br>");
            out.println("<br>Peso: "+ dc.getPeso()+"KG<br>");
            out.println("<br>Estatura: "+ dc.getEstatura()+"CM<br>");          
            out.println("<br>IMC: "+ dc.calcularIMC(dc.getPeso(), dc.getEstatura())+"<br>");
            
            out.println("<form id=\"formulario\" method=\"get\" action=\"Inicio\">");
            out.println("<div class=\"input-container\">");
            out.println("<input type=\"submit\" value=\"Ver tabla\">");
            out.println("</div>");
            out.println("</form>");
                     
            out.println("<br><form method=\"get\" action=\"ServerletRutina\">");
            out.println("<h2>Selecciona tu objetivo:</h2>");
            out.println("<section class=\"input-container\">"); 
            
            out.println("<div class=\"input-container\">"); 
            out.println("<label for=\"bajar-peso\">Bajar de peso</label>");
            out.println("<input type=\"radio\" name=\"objetivo\" id=\"bajar-peso\" value=\"Bajar de peso\" required>");
            out.println("</div>");
            
            out.println("<div class=\"input-container\">");
            out.println("<label for=\"aumentar-masa\">Aumentar masa muscular</label>");
            out.println("<input type=\"radio\" name=\"objetivo\" id=\"aumentar-masa\" value=\"Aumentar masa muscular\" required>");
            out.println("</div>"); 
            
            out.println("<div class=\"input-container\">"); 
            out.println("<label for=\"mejorar-resistencia\">Mejorar resistencia</label>");
            out.println("<input type=\"radio\" name=\"objetivo\" id=\"mejorar-resistencia\" value=\"Mejorar Resistencia\" required>");           
            out.println("</div>"); 
            
            out.println("<div class=\"input-container\">");
            out.println("<label for=\"dias\">Dias que va hacer ejercicio a la semana (entre 2 y 6): </label>");
            out.println("<input type=\"text\" name=\"dias\" id=\"dias\" >");
            out.println("</div>");
            
            out.println("<div class=\"input-container\">"); 
            out.println("<input type=\"submit\" value=\"Ver Rutina\">");
            out.println("</form>");
            out.println("</div>");
            out.println("</section>"); 
            out.println("</body>");
            out.println("</html>");
            
            
            datosDB.insertarContacto(dc);
            
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
