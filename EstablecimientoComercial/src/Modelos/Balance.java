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

    public Balance(String periodo, ArrayList<Venta> ventas, ArrayList<Distribuidor> distribuidores, ArrayList<Empleado> empleados) {
        this.periodo = periodo;
        this.ventas = ventas;
        this.distribuidores = distribuidores;
        this.empleados = empleados;
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
        
        
}
