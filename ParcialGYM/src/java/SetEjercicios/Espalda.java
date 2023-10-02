/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SetEjercicios;

/**
 *
 * @author juand
 */
public class Espalda implements Ejercicios{
    
    private String nombre;
    private String tipoejercicio;
    
    public Espalda(String nombre){
        this.nombre = nombre;
        this.tipoejercicio = "Espalda";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTipoejercicio() {
        return tipoejercicio;
    }
    
}
