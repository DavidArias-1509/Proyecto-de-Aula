<<<<<<<< HEAD:EstablecimientoComercial/src/persistencias/Mes.java
package persistencias;

import java.util.ArrayList;
import java.util.Map;
import modelos.cuentas.Balance;
import modelos.cuentas.Compra;
import modelos.cuentas.Dia;
import modelos.cuentas.Venta;
import modelos.employee.Empleado;
========
package cuentas;

import java.util.ArrayList;
import java.util.Map;
import empleados.Empleado;
>>>>>>>> 4f37e06b8bf7de3963dc8f7113a728c11e83cc21:EstablecimientoComercial/src/cuentas/Mes.java

public class Mes implements Balance {
    private ArrayList<Dia> balanceMes;
    private ArrayList<Dia> dias;
    

    public Mes() {
        this(new ArrayList());
    }

    public Mes(ArrayList<Dia> dias) {
        this.dias = dias;
//        this.empleados = empleados;
        this.balanceMes = new ArrayList();
    }

    public ArrayList<Dia> getDias() {
        return dias;
    }

    public ArrayList<Dia> getBalanceMes() {
        return balanceMes;
    }

//    public ArrayList<Empleado> getEmpleados() {
//        return empleados;
//    }

    public void setDias(ArrayList<Dia> dias) {
        this.dias = dias;
    }

//    public void setEmpleados(ArrayList<Empleado> empleados) {
//        this.empleados = empleados;
//    }
    
    public void agregarDia(Dia d){
        this.dias.add(d);
    }
    
    public void mesBalance(int mes, int anio){
        double balance=0;
        this.balanceMes.clear();
        for(Dia d: this.dias){
            if(d.getFecha().getYear()==anio && d.getFecha().getMonthValue() == mes){
                this.balanceMes.add(d);
            }
        }
    }
    public static double producidoVenta(Mes m){
        double producido = 0;
        for(Dia d : m.getBalanceMes()){
            for(Venta v : d.getVentas()){
                producido += v.calcularPrecio();
            }
        }
        return producido;
    }
    
    public static double gastosCompra(Mes m){
        double gastos = 0;
            for(Dia d : m.getBalanceMes()){
                for(Compra c : d.getCompras()){
                    gastos += c.getValorTotal();
                }
            }
        return gastos;
    }
    
    public static double nomina(Mes m){
        double nomi =0;
        for(Dia d : m.getBalanceMes()){
            for(Empleado e: d.getAsistencia()){
                nomi += e.calcularSalario();
            }
        }
        return nomi;
    }

    @Override
    public double calcularBalance() {
        return producidoVenta(this)- gastosCompra(this)- nomina(this);
    }
    
}
