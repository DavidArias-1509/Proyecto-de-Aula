/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Balance {
    private ArrayList<Venta> ventas;
    private ArrayList<Empleado> empleados;
    private String periodo;

    public Balance(String periodo) {
        this.periodo = periodo;
        this.ventas= new ArrayList();
        this.empleados= new ArrayList();
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    public void agregarVenta(Venta sale){
        if(this.consultarVenta(()==null){
            
        }
    }
    
    public Venta consultarVenta(long code){
        if(this.ventas!=null){
            for(Venta s: this.ventas){
                if(){
                    return s;
                }
            }
        }
        return null;
    }
    
   public void registarEmpleado(){
       
   }
   
   public Empleado consultarEmpleado(Empleado employee){
       return null;
   }
    
    
}
