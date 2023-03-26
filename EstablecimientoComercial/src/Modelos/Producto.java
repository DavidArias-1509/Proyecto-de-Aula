/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author david
 */
public class Producto {
    private String nombre;
    private int codigo;
    private int cantidadDisponible;
    private String descripcion;

   public Producto(){
       this("Null", 0,0);
   }
    public Producto(String nombre, int codigo, int cantidadDisponible) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion="No hay descripcion aun";
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+ "\nCodigo: "+this.codigo+"\nCantidad Disponible: "+this.cantidadDisponible
                +"\nDescripcion: "+this.descripcion+"\n****************";
    }
    
}
