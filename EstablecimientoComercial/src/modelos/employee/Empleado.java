/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.employee;

/**
 *
 * @author david
 */
public abstract class Empleado {
        private String nombre;
        private long identificacion;

    public Empleado(String nombre, long identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }
      
  public abstract double calcularSalario();
}
