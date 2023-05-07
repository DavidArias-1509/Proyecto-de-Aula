/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.employee;

/**
 *
 * @author david
 */
public class Normal extends Empleado implements CalcularSalarios {
    private double pagoPorDia;
    private double bonificacion;
    private int diasTrabajados;

    public Normal(double pagoPorDia, double bonificacion, int diasTrabajados, String nombre, long identificacion) {
        super(nombre, identificacion);
        this.pagoPorDia = pagoPorDia;
        this.bonificacion = bonificacion;
        this.diasTrabajados = diasTrabajados;
    }

    public Normal(double pagoPorDia, double bonificacion, String nombre, long identificacion) {
        super(nombre, identificacion);
        this.pagoPorDia = pagoPorDia;
        this.bonificacion = bonificacion;
        this.diasTrabajados=0;
    }
    
    public double getPagoPorDia() {
        return pagoPorDia;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setPagoPorDia(double pagoPorDia) {
        this.pagoPorDia = pagoPorDia;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }
    
    @Override
    public double calcularSalario() {
        return 0;    
    }
    
}
