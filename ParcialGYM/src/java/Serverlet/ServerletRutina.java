/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SetEjercicios.*;
import Clientes.*;
import Rutina.*;

/**
 *
 * @author juand
 */
@WebServlet(name = "ServerletRutina", urlPatterns = {"/ServerletRutina"})
public class ServerletRutina extends HttpServlet {

    
    public static Rutina rut;
    public static void liskov(Rutina r){
        r.sets();
        r.reps();
        r.consejo();
        rut=r;
    }
    
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
            dc.setRutina(request.getParameter("objetivo"));
            String objetivo = request.getParameter("objetivo");
            String diasString = request.getParameter("dias");
            int dias = Integer.parseInt(diasString);

            if("Bajar de peso".equals(objetivo)){
                Definicion definicion = new Definicion();
                definicion.sets();
                definicion.reps();
                definicion.consejo();
                liskov(definicion);
            }else{
                if("Aumentar masa muscular".equals(objetivo)){
                    MasaMuscular muscular = new MasaMuscular();
                    muscular.sets();
                    muscular.reps();
                    muscular.consejo();
                    liskov(muscular);
                }else{
                    if("Mejorar Resistencia".equals(objetivo)){
                        Resistencia resistencia = new Resistencia();
                        resistencia.sets();
                        resistencia.reps();
                        resistencia.consejo();
                        liskov(resistencia);
                    }
                        
                }
            }
            
            
            List<Ejercicios> ejercicioBrazo = new ArrayList<>();
            ejercicioBrazo.add(new Brazo("Curl de Biceps"));
            ejercicioBrazo.add(new Brazo("Curl de Martillo"));
            ejercicioBrazo.add(new Brazo("Predicador"));
            ejercicioBrazo.add(new Brazo("Fondos"));
            ejercicioBrazo.add(new Brazo("Press Francés"));
            ejercicioBrazo.add(new Brazo("Extensión de Triceps en Polea"));
                    
            
            List<Ejercicios> ejercicioPecho = new ArrayList<>();
            ejercicioPecho.add(new Pecho("Press Banca"));
            ejercicioPecho.add(new Pecho("Aperturas Inclinadas"));
            ejercicioPecho.add(new Pecho("Press Banco Inclinado con Mancuernas"));
            ejercicioPecho.add(new Pecho("Press Banco Declinado"));
            ejercicioPecho.add(new Pecho("Aperturas en Maquina"));
            
            List<Ejercicios> ejercicioEspalda = new ArrayList<>();
            ejercicioEspalda.add(new Espalda("Jalon al Pecho"));
            ejercicioEspalda.add(new Espalda("Remo con Mancuerna"));
            ejercicioEspalda.add(new Espalda("Remo con Barra T"));
            ejercicioEspalda.add(new Espalda("Pull Over con Polea"));
            ejercicioEspalda.add(new Espalda("Remo Sentado"));
            ejercicioEspalda.add(new Espalda("Dominadas"));
            ejercicioEspalda.add(new Espalda("Encogimiento de Hombros con Mancuernas"));
            
            List<Ejercicios> ejercicioPierna = new ArrayList<>();
            ejercicioPierna.add(new Pierna("Sentadilla Bulgara"));
            ejercicioPierna.add(new Pierna("Sentadilla Libre"));
            ejercicioPierna.add(new Pierna("Zancada"));
            ejercicioPierna.add(new Pierna("Hack Squat"));
            ejercicioPierna.add(new Pierna("Extensión de Aductores"));
            ejercicioPierna.add(new Pierna("Extensión de Abductores"));
            ejercicioPierna.add(new Pierna("Elevación de Gemelos"));
            
            List<Ejercicios> ejercicioAbdomen = new ArrayList<>();
            ejercicioAbdomen.add(new Abdomen("Crunches"));
            ejercicioAbdomen.add(new Abdomen("Elevacion de Piernas"));
            ejercicioAbdomen.add(new Abdomen("Giros Rusos"));
            ejercicioAbdomen.add(new Abdomen("Escaladores"));
            ejercicioAbdomen.add(new Abdomen("Crunches Oblicuos"));
            
           
            
            List<List<Ejercicios>> rutinaSemana = new ArrayList<>();
            rutinaSemana.add(ejercicioBrazo);
            rutinaSemana.add(ejercicioPecho);
            rutinaSemana.add(ejercicioEspalda);
            rutinaSemana.add(ejercicioPierna);
            rutinaSemana.add(ejercicioAbdomen);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"styles.css\">");
            out.println("<title>Rutina Semana</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<section class=formulario>");
            out.println("<h1>Rutina para " + dc.getRutina()+"</h1>" );
            out.println(rut.getConsejo());
            
            Collections.shuffle(rutinaSemana);
            
            if(dias >= 2 && dias <= 5){
                for (int i = 0; i < rutinaSemana.size(); i++) {
                    out.println("<h2>Rutina " + (i + 1) + "</h2>");
                    out.println("<ul>");


                    int cantejercicios = 0;

                    List<Ejercicios> ejerciciosRandom = new ArrayList<>(rutinaSemana.get(i));

                    Collections.shuffle(ejerciciosRandom);

                    for (Ejercicios ejercicio : ejerciciosRandom) {
                        if (cantejercicios >= 4) {
                            break;
                        }
                        out.println("<li>" + ejercicio.getNombre() + " (" + ejercicio.getTipoejercicio() + ") " + rut.getReps() + " x " + rut.getSets() + "</li>");
                        out.println("<img src=\"img/" + ejercicio.getNombre() + ".png\" alt=\"" + ejercicio.getNombre() + "\">");
                        cantejercicios++;
                    }

                    out.println("</ul>");
                }
                out.println("</section>"); 
            }else{
                response.sendRedirect("index.html");
            }

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
