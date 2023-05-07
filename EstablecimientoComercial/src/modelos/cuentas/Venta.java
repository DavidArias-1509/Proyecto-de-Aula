/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.cuentas;

import java.util.ArrayList;
import modelos.employee.Empleado;
import modelos.preparaciones.Receta;

/**
 *
 * @author david
 */
public class Venta {
    private ArrayList<Receta> platos;
    private Empleado empleado;

    public Venta(ArrayList<Receta> platos, Empleado empleado) {
        this.platos = platos;
        this.empleado = empleado;
    }

    public ArrayList<Receta> getPlatos() {
        return platos;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setPlatos(ArrayList<Receta> platos) {
        this.platos = platos;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
}