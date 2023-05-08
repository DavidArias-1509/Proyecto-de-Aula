package modelos.cuentas;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.preparaciones.Ingrediente;
import static vista.Main_Principal.I1;
import static vista.Main_Principal.mes;

public class Compra {
   private char encontro;
   private int codigo;
   private double valorTotal;
   private ArrayList<Producto> productos;
   private LocalDate fechaCompra;

    public Compra(){
        this(LocalDate.now());
    }
    
    public Compra(LocalDate fecha){
        this.encontro='n';
        this.fechaCompra = LocalDate.now();
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
}
