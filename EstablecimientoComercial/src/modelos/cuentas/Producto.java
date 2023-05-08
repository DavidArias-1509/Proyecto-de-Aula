package modelos.cuentas;

public class Producto {
    private String nombre;
    private int cantidadDisponible;
    private double precio;
    private String descripcion;

    public Producto(String nombre, int cantidadDisponible, double precio, String descripcion) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCnatidadDisponible() {
        return cantidadDisponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCnatidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return this.nombre+"                     "+this.cantidadDisponible;
    }
}
