/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import static vista.Main_Principal.I1;

/**
 *
 * @author david
 */
public class Compras {
   private double valorTotal;
   private ArrayList<Producto> productos;
   private LocalDate fechaCompra;

    public Compras(){
        this.fechaCompra = LocalDate.now();
        this.productos = new ArrayList();
        this.valorTotal = 0;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
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
    
    public void agregaACarrito(Producto p){
        this.productos.add(p);
        this.valorTotal += (p.getPrecio()* p.getCnatidadDisponible());
    }
    public void agregaACarrito(String nombre, int cantidad, double precio, String descripcion){
        Producto p = new Producto(nombre,cantidad,precio,descripcion);
        this.productos.add(p);
        this.valorTotal += (p.getPrecio()* p.getCnatidadDisponible());
    }
    
    public void eliminarCarrito(Producto p){
        for (Producto p1: productos){
            if (p1.getNombre().equals(p.getNombre())){
                this.valorTotal -= (p1.getPrecio()*p1.getCnatidadDisponible());
                this.productos.remove(p1);
            }
        }
        
    }
    public void eliminarCarrito(String nombreProducto){
        for (Producto p1: productos){
            if (p1.getNombre().equals(nombreProducto)){
                this.valorTotal -= (p1.getPrecio()*p1.getCnatidadDisponible());
                this.productos.remove(p1);
                
            }
        }
    }
    
    public void realizarCompra(){
        for(Producto p : this.productos){
            I1.agregarItem(p);
        }
    }
}
