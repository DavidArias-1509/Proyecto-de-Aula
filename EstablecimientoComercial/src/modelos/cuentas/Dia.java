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
public class Dia implements Balance{
    private ArrayList<Venta> ventas;
    private ArrayList<Compras> compras;
    private ArrayList<Empleado> asistencia;

    public Dia(ArrayList<Venta> ventas, ArrayList<Compras> compras, ArrayList<Empleado> asistencia) {
        this.ventas = ventas;
        this.compras = compras;
        this.asistencia = asistencia;
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

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public void setCompras(ArrayList<Compras> compras) {
        this.compras = compras;
    }

    public void setAsistencia(ArrayList<Empleado> asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public double calcularBalance() {
       return 0;
        }
    
}
