/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.preparaciones;

/**
 *
 * @author david
 */
public class Unitario extends Ingrediente {
    private double precioPorUnd;

    public Unitario(double precioPorUnd, String nombre, int cantidadDisponible) {
        super(nombre, cantidadDisponible);
        this.precioPorUnd = precioPorUnd;
    }

    public double getPrecioPorUnd() {
        return precioPorUnd;
    }

    public void setPrecioPorUnd(double precioPorUnd) {
        this.precioPorUnd = precioPorUnd;
    }
    
}
