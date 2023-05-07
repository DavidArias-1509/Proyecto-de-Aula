/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.preparaciones;

/**
 *
 * @author david
 */
public class PorPeso extends Ingrediente{
    private double precioPorGr;

    public PorPeso(double precioPorGr, String nombre, int cantidadDisponible) {
        super(nombre, cantidadDisponible);
        this.precioPorGr = precioPorGr;
    }

    public double getPrecioPorGr() {
        return precioPorGr;
    }

    public void setPrecioPorGr(double precioPorGr) {
        this.precioPorGr = precioPorGr;
    }
    
}
