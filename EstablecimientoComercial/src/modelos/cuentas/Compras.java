/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.cuentas;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Compras {
   private double valorTotal;
    private ArrayList<Ingrediente> ingredientes;

    public Compras(double valorTotal, ArrayList<Ingrediente> ingredientes) {
        this.valorTotal = valorTotal;
        this.ingredientes = ingredientes;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
}
