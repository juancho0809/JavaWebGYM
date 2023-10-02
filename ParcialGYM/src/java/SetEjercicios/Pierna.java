/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SetEjercicios;

/**
 *
 * @author juand
 */
public class Pierna implements Ejercicios{
    
    private String nombre;
    private String tipoejercicio;
    
    public Pierna(String nombre){
        this.nombre = nombre;
        this.tipoejercicio = "Pierna";
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
