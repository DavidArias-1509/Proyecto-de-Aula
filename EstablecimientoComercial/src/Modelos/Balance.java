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
        private String periodo;
        private ArrayList<Venta> ventas;
        private ArrayList<Distribuidor> distribuidores;
        private ArrayList<Empleado> empleados;
        private double salrios;
        private long  deudas;
        private long producido;
        private double balanceFinal;
        
   public Balance(){
       this("Mes-Mes", null, null,null);
   }
   
    public Balance(String periodo, ArrayList<Venta> ventas, ArrayList<Distribuidor> distribuidores, ArrayList<Empleado> empleados) {
        this.periodo = periodo;
        this.ventas = ventas;
        this.distribuidores = distribuidores;
        this.empleados = empleados;
        this.deudas=0;
        this.salrios=0;
        this.producido=0;
        this.balanceFinal=0;
        
        
    }

    public String getPeriodo() {
        return periodo;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public ArrayList<Distribuidor> getDistribuidores() {
        return distribuidores;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public double getSalrios() {
        return salrios;
    }

    public double getDeudas() {
        return deudas;
    }

    public double getProducido() {
        return producido;
    }

    public double getBalanceFinal() {
        return balanceFinal;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public void setDistribuidores(ArrayList<Distribuidor> distribuidores) {
        this.distribuidores = distribuidores;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setSalrios(double salrios) {
        this.salrios = salrios;
    }

    public void setDeudas(long deudas) {
        this.deudas = deudas;
    }

    public void setProducido(long producido) {
        this.producido =producido;
    }

    public void setBalanceFinal(double balanceFinal) {
        this.balanceFinal = balanceFinal;
    }
    
    public double calcularBalance(){
         return this.balanceFinal=(double)this.producido-(this.deudas+this.salrios);
        
    }
        
        @Override
    public String toString(){
        return "Preiodo: "+this.periodo+"\nTotal Nomina: "+this.salrios +"\nDeudas a Proveedores: "+this.deudas+
                "\nProducido por ventas: "+this.producido +"\nBalance: "+this.calcularBalance();
    }
}
