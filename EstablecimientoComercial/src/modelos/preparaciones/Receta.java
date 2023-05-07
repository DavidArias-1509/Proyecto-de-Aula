package modelos.preparaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class Receta {
    private String nombre;
    private List<Ingrediente> ingredientes = new ArrayList();

    public Receta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public void agregarIngrediente(Ingrediente I){
        this.ingredientes.add(I);
    }
    
    public double calcularPrecio(){
        double precio=0;
        for(Ingrediente I: ingredientes){
           precio += I.getPrecio()*I.getCantidad();
        }
        return precio;
    }
}
