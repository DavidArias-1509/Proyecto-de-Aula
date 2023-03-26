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

    public Venta() {
        this(null,null,0,LocalDate.now());
        this.articulo = new ArrayList();
        this.valorVenta = 0;
        this.puntosVenta = 0;
    }

    public Venta(Cliente comprador, Empleado vendedor, double descuento, LocalDate fechaVenta) {
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
        return valorVenta;
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
    
    public void registrarProducto(Producto p){
        this.articulo.add(p);
        this.valorVenta += p.getPrecio();
        this.puntosVenta++;
    }
    
    @Override
    public String toString() {
        return "Venta{" + "comprador=" + comprador + ", vendedor=" + vendedor + ", articulo=" + articulo + ", descuento=" + descuento + ", valorVenta=" + valorVenta + ", puntosVenta=" + puntosVenta + ", fechaVenta=" + fechaVenta + '}';
    }
    

}
