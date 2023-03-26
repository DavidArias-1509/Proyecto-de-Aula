/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Venta {
    private Cliente comprador;
    private Empleado vendedor;
    private ArrayList<Producto> articulo;
    private double descuento;
    private double valorVenta;
    private double puntosVenta;
    private LocalDate fechaVenta;
    private long codigoVenta;

    public Venta() {
        this(null,null,0,LocalDate.now(),0000001L);
        this.articulo = new ArrayList();
        this.valorVenta = 0;
        this.puntosVenta = 0;
    }

    public Venta(Cliente comprador, Empleado vendedor, double descuento, LocalDate fechaVenta, long codigoVenta) {
        this.codigoVenta = codigoVenta;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.articulo = new ArrayList();
        this.descuento = descuento;
        this.valorVenta = 0;
        this.puntosVenta = 0;
        this.fechaVenta = fechaVenta;
    }

    
    /**
     * @return the comprador
     */
    public Cliente getComprador() {
        return comprador;
    }

    /**
     * @param comprador the comprador to set
     */
    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    /**
     * @return the vendedor
     */
    public Empleado getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the valorVenta
     */
    public double getValorVenta() {
        return  this.valorVenta - (this.valorVenta*(this.descuento/100));
    }

    /**
     * @return the puntosVenta
     */
    public double getPuntosVenta() {
        return puntosVenta;
    }

    /**
     * @return the fechaVenta
     */
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public void registrarProducto(ArrayList<Producto> p){
        for (Producto a : p){
            registrarProducto(a);
        }
    }
    
    public void registrarProducto(Producto p){
        if (p.getCantidadVenta()<= p.getCantidadDisponible()){
            this.getArticulo().add(p);
            //Aqui acumula el valor total de los productos
            this.valorVenta += (p.getPrecio()*p.getCantidadVenta());
            //Puntos de venta aumenta en la cantidad de articulos que compres
            this.puntosVenta += p.getCantidadVenta();
            p.setCantidadDisponible(p.getCantidadDisponible()-p.getCantidadVenta());
        }else{
            System.out.println("la cantidad excede las existencias");
        }
        
    }
    
    

    /**
     * @return the articulo
     */
    public ArrayList<Producto> getArticulo() {
        return articulo;
    }
    
    @Override
    public String toString() {
        return "Venta{" + "comprador=" + comprador + ", vendedor=" + vendedor + ", articulo=" + getArticulo() + ", descuento=" + descuento + ", valorVenta=" + valorVenta + ", puntosVenta=" + puntosVenta + ", fechaVenta=" + fechaVenta + '}';
    }

}
