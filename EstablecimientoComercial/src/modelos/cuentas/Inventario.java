/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.cuentas;

import java.util.ArrayList;
import modelos.preparaciones.Ingrediente;

/**
 *
 * @author karla
 */
public class Inventario {
    private ArrayList <Producto> Item;

    public Inventario() {
    }
    
    public void agregarItem(Producto p){
        char Encontro = 'n';
        int adicion;
        for (Producto p1 : Item){
            if (p1.getNombre().equals(p.getNombre())){
                Encontro = 's';
                adicion = p1.getCnatidadDisponible() + p.getCnatidadDisponible();
                p1.setCnatidadDisponible(adicion);
                p1.setPrecio(p.getPrecio());
            }
        }
        if(Encontro == 'n'){
            this.Item.add(p);
        }
    }
    
    public void reducirItem(Ingrediente i){
        char Encontro = 'n';
        int reduccion;
        for (Producto p1 : Item){
            if (i.getNombre().equals(p1.getNombre())){
                Encontro = 's';
                reduccion = p1.getCnatidadDisponible() - i.getCantidad();
                p1.setCnatidadDisponible(reduccion);
            } else {
            }
        }
        if(Encontro == 'n'){
            System.out.println("No se encontro Item");
        }
    }
}
