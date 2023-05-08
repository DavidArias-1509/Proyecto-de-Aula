package modelos.cuentas;

import java.util.ArrayList;
import java.util.Map;
import modelos.employee.Empleado;

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
    
    public double mesBalance(int mes, int anio){
        double balance=0;
        this.balanceMes.clear();
        for(Dia d: this.dias){
            if(d.getFecha().getYear()==anio && d.getFecha().getMonthValue() == mes){
                this.balanceMes.add(d);
            }
        }
        balance = this.calcularBalance();
        return balance;
    }

    @Override
    public double calcularBalance() {
        double balance=0;
        for(Dia d : this.balanceMes){
            balance += d.calcularBalance();
        }
        return balance;
    }
    
    
}
