/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rutina;

/**
 *
 * @author juand
 */
public class Rutina {
    int sets;
    int reps;
    String consejo;

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }
    
    public void sets(){
        sets = 0;
    }
    
    public void reps(){
        reps = 0;
    }
    
    public void consejo(){
        consejo = "";
    }
}
