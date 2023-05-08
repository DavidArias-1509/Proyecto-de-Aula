package modelos.cuentas;

import java.util.ArrayList;
import modelos.employee.Empleado;

public class Mes implements Balance {
    private ArrayList<Dia> dias;
    private ArrayList<Empleado> empleados;

    public Mes() {
        this.dias = new ArrayList();
        this.empleados = new ArrayList();
    }

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
    
    public void agregarDia(Dia d){
        this.dias.add(d);
    }

    @Override
    public double calcularBalance() {
        double balance=0;
        for(Dia d : this.dias){
            balance += d.calcularBalance();
        }
        return balance;
    }
    
    
}
