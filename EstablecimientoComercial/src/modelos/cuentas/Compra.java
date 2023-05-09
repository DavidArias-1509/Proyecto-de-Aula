package modelos.cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Entrada;
import static modelos.Entrada.leerFecha;
import modelos.employee.Administrador;
import modelos.employee.Empleado;
import modelos.preparaciones.Ingrediente;
import static vista.Main_Principal.I1;
import static vista.Main_Principal.mes;
import static vista.Main_Principal.personal;

public class Compra {
    private String codigoCompra;
   private char encontro;
   private double valorTotal;
   private ArrayList<Producto> productos;
   private LocalDate fechaCompra;

    public Compra(){
        this(LocalDate.now());
    }
    
    public Compra(LocalDate fecha){
        this.encontro='n';
         int secuencia = 1;
        this.fechaCompra = LocalDate.now();
        for(Dia d: mes.getDias()){
            if(d.getFecha().equals(this.fechaCompra )){
                encontro = 's';
                secuencia = d.getVentas().size()+1;
                break;
            }
        }
        for(Dia d: mes.getDias()){
            if(this.fechaCompra.equals(d.getFecha())){
                encontro = 's';
            }
        }
        if (this.encontro == 'n'){
            Dia d1 = new Dia();
            mes.agregarDia(d1);
        }
        this.productos = new ArrayList();
        this.codigoCompra = ""+ this.fechaCompra.getYear() + this.fechaCompra.getMonthValue() + this.fechaCompra.getDayOfMonth() + secuencia + "";
        this.valorTotal = 0;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<Producto> getIngredientes() {
        return productos;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void setIngredientes(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    public void agregaACarrito(Producto p){
        this.productos.add(p);
        this.valorTotal += (p.getPrecio()* p.getCnatidadDisponible());
    }
    public void agregaACarrito(String nombre, int cantidad, double precio, String descripcion){
        Producto p = new Producto(nombre,cantidad,precio,descripcion);
        this.productos.add(p);
        this.valorTotal += (p.getPrecio()* p.getCnatidadDisponible());
    }
    
    public void eliminarCarrito(Producto p){
        for (Producto p1: productos){
            if (p1.getNombre().equals(p.getNombre())){
                this.valorTotal -= (p1.getPrecio()*p1.getCnatidadDisponible());
                this.productos.remove(p1);
            }
        }
        
    }
    public void eliminarCarrito(String nombreProducto){
        for (Producto p1: productos){
            if (p1.getNombre().equals(nombreProducto)){
                this.valorTotal -= (p1.getPrecio()*p1.getCnatidadDisponible());
                this.productos.remove(p1);
                
            }
        }
    }
    
    public void realizarCompra(){
        for(Producto p : this.productos){
            I1.agregarItem(p);
        }
        for(Dia d : mes.getDias()){
            if(this.fechaCompra.equals(d.getFecha())){
                d.agregarCompra(this);
            }
        }
    }

    public static void RegistroCompra(){
        if(validacion()){
            int opc = 0;
            System.out.println("rRegistro de Compra");
            System.out.println("---------------------------");
            System.out.println("1. Compra de Ingredientes");
            System.out.println("2. Otras Compras");
            do{
                opc = Entrada.leerEntero("Elija Opcion enttre (1-2)");
            }while (opc == 1 || opc ==2);
            
            char encontro = 'n';
            LocalDate fecha;
            System.out.println("Registro de Compra");
            System.out.println("---------------------------");
            //Leemos Fecha
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
            Compra c = new Compra(fecha);
            encontro='n';
            char op = 'n';
            String desc = "";
            double precio = 0;
            int cantidad = 0;
            do{
                if(opc==1){
                    desc = Entrada.leerString("Ingrediente: ");
                }else{
                    desc = Entrada.leerString("Descripcion: ");
                }
                cantidad = Entrada.leerEntero("Cantidad: ");
                precio = Entrada.leerDouble("Precio Por Unidad");
                op = Entrada.leerCaracter("Desea gregar otro plato (S/N)");
            }while(op == 'n' || op== 'N');
            op = Entrada.leerCaracter("Desea realizar compra (S/N)");
            if(opc==1){
                c.agregaACarrito(desc, cantidad, precio, "");
            }else{
                c.agregaACarrito(desc, cantidad, precio, desc);
            }
            if(op == 's' || op== 'S'){
                c.realizarCompra();
            }
        }
    }
    
    
    public static boolean validacion(){//Validacion de usuario administrador
        boolean bol = false;
        System.out.println("Registro de compra");
        System.out.println("-------------------------");
        long usuario = Entrada.leerLong("Usuario : ");
        long Contrasena = Entrada.leerLong("Contrasena : ");
        if(usuario == 123L && Contrasena == 1234L){
            bol = true;
        }else{
            for(Empleado e : personal){
                if(usuario == e.getIdentificacion() && (e instanceof Administrador)){
                    if(Contrasena == e.getIdentificacion()){
                       bol = true;
                    }else{
                        System.out.println("Error en contraseña...");
                        bol = false;
                    }
                }
            }
        }
        if(!bol){
            System.out.println("Acceso no permitido");
        }
       return bol;
    }


    public String getCodigoCompra() {
        return codigoCompra;
    }

    public char getEncontro() {
        return encontro;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void detalle(){
        System.out.println("Compra");
        System.out.println("Porducto(s)");
        for(Producto p : this.productos){
            System.out.println("Nombre: "+p.getNombre());
            System.out.println("Descripcion: "+p.getDescripcion());
            System.out.println("Precio: "+p.getPrecio());
        }
        System.out.println("\nTotal Compra: "+this.valorTotal);
    }
}
