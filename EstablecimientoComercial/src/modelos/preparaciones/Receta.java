/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.preparaciones;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
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
    
    public void agregarIngrediente(){
        
    }
    
    public  double calcularPrecio(){
       Ingrediente i1 = new Unitario(2100, "nose", 300);
       double precio = i1.obtenerPrecio();
       return 0;
    }
}
