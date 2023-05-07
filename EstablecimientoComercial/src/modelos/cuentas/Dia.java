/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.employee.Empleado;

/**
 *
 * @author david
 */
public class Dia implements Balance{
    private ArrayList<Venta> ventas;
    private ArrayList<Compras> compras;
    private ArrayList<Empleado> asistencia;
    private LocalDate fecha;

    public Dia(LocalDate fecha) {
        this.ventas = new ArrayList();
        this.compras = new ArrayList();
        this.asistencia = new ArrayList();
        this.fecha = fecha;
    }

    public Dia(){
        this.ventas = new ArrayList();
        this.compras = new ArrayList();
        this.asistencia = new ArrayList();
        this.fecha = LocalDate.now();
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public ArrayList<Compras> getCompras() {
        return compras;
    }

    public ArrayList<Empleado> getAsistencia() {
        return asistencia;
    }
public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public void setCompras(ArrayList<Compras> compras) {
        this.compras = compras;
    }

    public void setAsistencia(ArrayList<Empleado> asistencia) {
        this.asistencia = asistencia;
    }
    
    public void agregarCompra(Compras c){
        this.compras.add(c);
        System.out.println("Compra registrada");
    }
    
    public void agregarVenta(Venta v){
        this.ventas.add(v);
        System.out.println("Venta registrada");
    }
    
    public void registarAsistencia(Empleado e){
        this.asistencia.add(e);
        System.out.println("Asistencia registrada");
    }
    
    @Override
    public double calcularBalance() {
       double balance=0;
        for(Venta v : this.ventas){
            balance+=0;
        }
        for(Compras c: this.compras){
            balance-=0;
        }
       return balance;
    }

    
    
}
