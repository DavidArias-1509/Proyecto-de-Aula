package Modelos;

/**
 *
 * @author david
 */
public class Cliente {
    private String nombre;
    private int identificacion;
    private int telefono;
    private String email;
    private int puntos;
    private double deudas;

    public Cliente(){
        this("Null",0,0,"Null@");
        this.puntos=0;
        this.deudas=0.0;
    }
    public Cliente(String nombre, int identificacion, int telefono, String email) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.email = email;
        this.puntos=0;
        this.deudas=0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdeentificacion() {
        return identificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getPuntos() {
        return puntos;
    }

    public double getDeudas() {
        return deudas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setDeudas(double deudas) {
        this.deudas = deudas;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+ "\nTelefono: "+this.telefono +"\nCedula: "+this.identificacion+ "\nPuntos: "+this.puntos
                +"\nDeuda: "+this.deudas;
    }
    
    
}
