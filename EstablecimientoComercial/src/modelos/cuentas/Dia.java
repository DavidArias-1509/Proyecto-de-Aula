package modelos.cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.employee.Empleado;

public class Dia implements Balance{
    private ArrayList<Venta> ventas;
    private ArrayList<Compra> compras;
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

    public ArrayList<Compra> getCompras() {
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

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public void setAsistencia(ArrayList<Empleado> asistencia) {
        this.asistencia = asistencia;
    }
    
    public void agregarCompra(Compra c){
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
        for(Compra c: this.compras){
            balance-=0;
        }
       return balance;
    }

    
    
}
