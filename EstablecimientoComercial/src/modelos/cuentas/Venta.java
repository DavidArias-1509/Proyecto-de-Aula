package modelos.cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.employee.Empleado;
import modelos.preparaciones.Receta;
import static vista.Main_Principal.mes;

public class Venta {
    private char encontro;
    private ArrayList<Receta> platos;
    private LocalDate fechaVenta;
    private Empleado empleado;
    private Cliente cliente;
    private double precioVenta;

    public Venta(ArrayList<Receta> platos, Empleado empleado, Cliente cliente) {
        this.encontro = 'n';
        this.platos = platos;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaVenta = LocalDate.now();
        for(Dia d: mes.getDias()){
            if(d.getFecha().equals(this.fechaVenta )){
                encontro = 's';
            }
        }
        if (this.encontro == 'n'){
            Dia d1 = new Dia();
            mes.agregarDia(d1);
        }
        this.precioVenta = 0;
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
    
    public void agregarReceta(Receta r){
        double valor=0;
        this.platos.add(r);
        for(Receta R: this.platos){
           valor+= R.calcularPrecio();
        }
        this.precioVenta = valor;
    }
    
    public double calcularPrecio(){
        return this.precioVenta;
    }
    
    public void realizarVenta(){
        this.calcularPrecio();
        for(Dia d: mes.getDias()){
            if(this.fechaVenta.equals(d.getFecha())){
                d.agregarVenta(this);
            }
        }
    }
}
