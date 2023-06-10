package cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Entrada;
import empleados.Empleado;
import empleados.Normal;
import java.io.Serializable;
import static vista.Main_Principal.pedirFecha;

public class Dia implements Balance,Serializable{
    private ArrayList<Venta> ventas;
    private ArrayList<Compra> compras;
    private ArrayList<Empleado> asistencia;
    private LocalDate fecha;
    private double balanceVenta;
    private double balanceCompra;

    public Dia(LocalDate fecha) {
        this.ventas = new ArrayList();
        this.compras = new ArrayList();
        this.asistencia = new ArrayList();
        this.balanceCompra = 0;
        this.balanceVenta = 0;
        this.fecha = fecha;
    }

    public double getBalanceVenta() {
        return balanceVenta;
    }

    public double getBalanceCompra() {
        return balanceCompra;
    }
    

    public Dia(){
        this(LocalDate.now());
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

    public void setAsistencia(Empleado e) {
        this.asistencia.add(e);
    }
    
    public void agregarCompra(Compra c){
        this.compras.add(c);
        System.out.println("Compra registrada");
    }
    
    public void agregarVenta(Venta v){
        this.ventas.add(v);
        System.out.println("Venta registrada");
    }
    
    public static void registarAsistencia(){
        if(Compra.validacion()){
            char encontro = 'n';
            LocalDate fecha = pedirFecha();
            char op = 'n' ;
            long id =0L;
            Dia d = new Dia(fecha);
            do{
                id = Entrada.leerLong("Indentificacion: ");
                encontro = 'n';
                Empleado e = new Normal(0,0,"",0);
                for(Empleado e1 : d.getAsistencia()){
                    if(e1.getIdentificacion() == e.getIdentificacion()){
                        System.out.println("Asistencia ya fue registrada");
                        e = e1;
                        encontro = 's';
                    }
                }
                if(encontro == 'n'){
                    if (e instanceof Normal normal){
                        normal.setDiasTrabajados(1);
                        e= normal;
                    }
                    d.setAsistencia(e);
                    System.out.println("Asistencia registrada");
                }
                op = Entrada.leerCaracter("Desea agregar otra asistencia: ");
            }while(op == 'n'||op == 'N');
            
        }
       
    }
    
    @Override
    public double calcularBalance() {
       double balance=0;
        for(Venta v : this.ventas){
            this.balanceVenta += v.calcularPrecio();
        }
        balance += this.balanceVenta; 
        for(Compra c: this.compras){
            this.balanceCompra+=c.getValorTotal();
        }
        System.out.println("Gastos en Compras: "+this.balanceCompra);
        balance -= this.balanceCompra;
       return balance; 
    }
}
