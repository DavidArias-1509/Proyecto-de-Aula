/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.cuentas;

import java.util.ArrayList;
import modelos.employee.Empleado;

/**
 *
 * @author david
 */
public class Mes implements Balance {
    private ArrayList<Dia> dias;
    private ArrayList<Empleado> empleados;

    public Mes(ArrayList<Dia> dias, ArrayList<Empleado> empleados) {
        this.dias = dias;
        this.empleados = empleados;
    }

    public ArrayList<Dia> getDias() {
        return dias;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setDias(ArrayList<Dia> dias) {
        this.dias = dias;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public double calcularBalance() {
        return 0;
    }
    
    
}
