/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


/**
 *
 * @author david
 */
public class Proveedor {
    private String NIT;
    private String nombre;
    private String Telefono;
    private double deudaDistribuidor;

    public Proveedor() {
        this(null,null,null,0);
    }

    public Proveedor(String NIT, String nombre, String Telefono, double deudaDistribuidor) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.Telefono = Telefono;
        this.deudaDistribuidor = deudaDistribuidor;
    }

    /**
     * @return the NIT
     */
    public String getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the deudaDistribuidor
     */
    public double getDeudaDistribuidor() {
        return deudaDistribuidor;
    }
    
    public void pagarDeuda(double pago){
        this.deudaDistribuidor -= pago;
    }

    @Override
    public String toString() {
        return "Distribuidor{" + "NIT=" + NIT + ", nombre=" + nombre + ", Telefono=" + Telefono + ", deudaDistribuidor=" + deudaDistribuidor + '}';
    }
    
}
