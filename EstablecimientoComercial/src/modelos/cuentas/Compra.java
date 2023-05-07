package modelos.cuentas;

import java.util.ArrayList;
import modelos.preparaciones.Ingrediente;

public class Compra {
    private double valorTotal;
    private ArrayList<Ingrediente> ingredientes;
    private String descripcion;

    public Compra(double valorTotal) {
        this.valorTotal = valorTotal;
        this.descripcion=null;
        this.ingredientes=new ArrayList();
    }

    public Compra() {
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<Ingrediente> getProductos() {
        return ingredientes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setProductos(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double calcularPrecio(){
        double valor=0;
        for(Ingrediente I: this.ingredientes ){
            valor+=I.getPrecio()*I.getCantidad();
        }
        return valor;
    }
            

    
    
}
