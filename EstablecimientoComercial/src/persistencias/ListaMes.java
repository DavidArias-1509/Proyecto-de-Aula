
package persistencias;

import cuentas.Dia;
import cuentas.Compra;
import cuentas.Producto;
import cuentas.Venta;
import java.util.ArrayList;
import empleados.Empleado;
import java.io.IOException;
import java.util.List;

public class ListaMes implements Logica {
    private ArrayList<Dia> balanceMes;
    private ArrayList<Dia> dia;
    

    public ListaMes() {
        this(new ArrayList());
    }

    public ListaMes(ArrayList<Dia> dias) {
        this.dia = dias;
//        this.empleados = empleados;
        this.balanceMes = new ArrayList();
    }

    public ArrayList<Dia> getDias() {
        return this.dia;
    }

    public ArrayList<Dia> getBalanceMes() {
        return balanceMes;
    }

//    public ArrayList<Empleado> getEmpleados() {
//        return empleados;
//    }

    public void setDias(ArrayList<Dia> dias) {
        this.dia = dia;
    }

//    public void setEmpleados(ArrayList<Empleado> empleados) {
//        this.empleados = empleados;
//    }
    
    public void agregarDia(Dia d){
        this.dia.add(d);
    }
    
    public void mesBalance(int mes, int anio){
        double balance=0;
        this.balanceMes.clear();
        for(Dia d: this.dia){
            if(d.getFecha().getYear()==anio && d.getFecha().getMonthValue() == mes){
                this.balanceMes.add(d);
            }
        }
    }
    public static double producidoVenta(ListaMes m){
        double producido = 0;
        for(Dia d : m.getBalanceMes()){
            for(Venta v : d.getVentas()){
                producido += v.calcularPrecio();
            }
        }
        return producido;
    }
    
    public static double gastosCompra(ListaMes m){
        double gastos = 0;
            for(Dia d : m.getBalanceMes()){
                for(Compra c : d.getCompras()){
                    gastos += c.getValorTotal();
                }
            }
        return gastos;
    }
    
    public static double nomina(ListaMes m){
        double nomi =0;
        for(Dia d : m.getBalanceMes()){
            for(Empleado e: d.getAsistencia()){
                nomi += e.calcularSalario();
            }
        }
        return nomi;
    }

//    @Override
//    public double calcularBalance() {
//        return producidoVenta(this)- gastosCompra(this)- nomina(this);
//    }

    @Override
    public Dia buscarItem(String id) {
        for (Dia d : this.dia){
            if(d.getFecha().equals(id)){
                return d;
            }
        }
        return null;
    }

    @Override
    public void borrarItem(String id) throws IOException {
        
    }

    @Override
    public void agregarItem(Object item) throws IOException {
        Dia d = (Dia) item;
        for (Dia d1 :this.dia){
            if(d.getFecha().equals(d1.getFecha())){
                throw new IOException("Dia ya esta registrado");
            }
        }
        this.dia.add(d);
    }

    @Override
    public List<Dia> generarInforme() throws IOException {
        return this.dia;
    }
    
}
