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
    private ArrayList<Producto> productos;

    public Compras(double valorTotal, ArrayList<Producto> productos) {
        this.valorTotal = valorTotal;
        this.productos = productos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<Producto> getIngredientes() {
        return productos;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setIngredientes(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
}
