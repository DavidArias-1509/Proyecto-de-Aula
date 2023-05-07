package modelos.cuentas;

import java.util.ArrayList;
import modelos.employee.Empleado;
import modelos.preparaciones.Receta;

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
    
    public void agregarReceta(Receta r){
        this.platos.add(r);
    }
    
    public double calcularPrecio(){
        double precio=0;
        for(Receta R: this.platos){
           precio += R.calcularPrecio();
        }
        return precio;
    }
}
