/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author david
 */
public class Empleado {
        private String nombre;
        private int identificacion;
        private long telefono;
        private String email; 
        private String sexo;
        private String direccion;
        private int edad;
        private double salarioBase;

    public Empleado(){
        this("Null", 0,0,"Null@","Unsigned","Unsigned",0);
    }
    public Empleado(String nombre, int identificacion, long telefono, String email, String sexo, String direccion, int edad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.direccion = direccion;
        this.edad = edad;
        this.salarioBase=1085670;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
        @Override
    public String toString(){
        return "Nombre. "+this.nombre+"\nIdentificacion: "+this.identificacion+"\nTelefono "+this.telefono+
                "Direccion: "+this.direccion+"\nEdad: "+this.edad+"\nSexo: "+this.sexo+"\nEmail: "+this.email+
                "\nSalario Base: "+this.salarioBase+"\n*******";
    }
        
        
}   
