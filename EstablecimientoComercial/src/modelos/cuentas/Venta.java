package modelos.cuentas;

import java.time.LocalDate;
import modelos.Entrada;
import java.util.ArrayList;
import static modelos.Entrada.leerFecha;
import modelos.employee.Empleado;
import modelos.preparaciones.Receta;
import static vista.Main_Principal.*;


public class Venta {
    private String codigoVenta;
    private ArrayList<Receta> platos;
    private LocalDate fechaVenta;
    private Empleado empleado;
    private Cliente cliente;
    private double precioVenta;

    public Venta( Empleado empleado, Cliente cliente) {
        char encontro = 'n';
        int secuencia = 1;
        this.platos = new ArrayList();
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaVenta = LocalDate.now();
        for(Dia d: mes.getDias()){
            if(d.getFecha().equals(this.fechaVenta )){
                encontro = 's';
                secuencia = d.getVentas().size()+1;
                break;
            }
        }
        if (encontro == 'n'){
            Dia d1 = new Dia();
            mes.agregarDia(d1);
        }
        this.codigoVenta = ""+ this.fechaVenta.getYear() + this.fechaVenta.getMonthValue() + this.fechaVenta.getDayOfMonth() + secuencia + "";
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
        double total=0;
        for(Receta r : this.platos){
           total+=r.calcularPrecio();
        }
        return total;
    }
    
    public void realizarVenta(){
        this.calcularPrecio();
        for(Dia d: mes.getDias()){
            if(this.fechaVenta.equals(d.getFecha())){
                d.agregarVenta(this);
            }
        }
    }
    
    public static void RegistroVenta(){
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
        encontro='n';
        System.out.println("Empleado");
        System.out.println("----------------------------");
        long id = Entrada.leerLong("Identificacion: ");
        Empleado e1=null;
        for (Empleado e: personal){            
            if(e.getIdentificacion() == id){
                encontro = 's';
                e1 = e;
                System.out.println("Nombre: "+ e.getNombre());
                break;
            }
        }
        if(encontro == 'n'){
            System.out.println("No se encontro empleado intente otra vez");
        }else{
            System.out.println("------------------------");
            System.out.println("Cliente");
            id = Entrada.leerLong("Identificacion: ");
            String nombre = Entrada.leerString("Nombre: ");
            String Email = Entrada.leerString("Email: ");
            Cliente c1 = new Cliente(nombre, Email, id);
            Venta v = new Venta(e1,c1);
            System.out.println("------------------------");
            System.out.println("Platos");
            char op;
            do{
                encontro = 'n';
                System.out.println("------------------------");
                String plato = Entrada.leerString("Nombre del plato: ");
                Receta r1= null;
                for(Receta r : libroReceta){
                    if(r.getNombre().equals(plato)){
                        encontro = 's';
                        r1 = r;
                        break;
                    }
                }
                if(encontro == 'n'){
                    op = Entrada.leerCaracter("No se encontro plato, desea agregar? (S/N)");

                }else{
                    v.agregarReceta(r1);
                }
                op = Entrada.leerCaracter("Desea finalizar (S/N)");
            }while(op =='N'|| op =='n');
            op = Entrada.leerCaracter("Desea Guardar Venta (S/N)");
            if (op == 's'|| op=='S'){
                for(Dia d : mes.getDias()){
                    if (d.getFecha().equals(fecha)){
                        d.agregarVenta(v);
                        System.out.println("Total venta: " + v.calcularPrecio());
                        break;
                    }
                }
            }
            
        }
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public void detalle(){
        System.out.println("-Empleado");
        System.out.println("Nombre: "+empleado.getNombre());
        System.out.println("Identificacion: "+empleado.getIdentificacion());
        System.out.println("-Cliente");
        System.out.println("Nombre: "+cliente.getNombre());
        System.out.println("Identificacion: "+cliente.getId());
        System.out.println("E-mail: "+cliente.getE_mail());
        System.out.println("-Platos");
        for(Receta r : this.platos){
            System.out.println(r);
        }
        System.out.println("\nTotal Venta: "+this.calcularPrecio());
    }
}
