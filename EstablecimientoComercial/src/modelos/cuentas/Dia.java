package modelos.cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Entrada;
import static modelos.Entrada.leerFecha;
import modelos.employee.Empleado;
import modelos.employee.Normal;
import static vista.Main_Principal.mes;
import static vista.Main_Principal.personal;

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
            LocalDate fecha;
            System.out.println("Registro de Venta");
            System.out.println("---------------------------");
            fecha = leerFecha("Fecha");
            System.out.println("---------------------------");
            for(Dia d : mes.getDias()){
                if (d.getFecha().equals(fecha)){
                    encontro = 's';
                    break;
                }
            }
            if (encontro == 'n'){
                Dia d = new Dia(fecha);
                mes.agregarDia(d);
            }
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
            balance+=v.calcularPrecio();
        }
        for(Compra c: this.compras){
            balance-=c.getValorTotal();
        }
        for (Empleado e: this.asistencia){
            balance -= e.calcularSalario();
        }
       return balance; 
    }

    
    
}
