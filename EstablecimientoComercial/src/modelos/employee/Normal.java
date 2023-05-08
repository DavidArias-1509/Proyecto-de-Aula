package modelos.employee;

public class Normal extends Empleado{
    private double pagoPorDia;
    private double bonificacion;
    private int diasTrabajados;

//    public Normal(double pagoPorDia, double bonificacion, int diasTrabajados, String nombre, long identificacion) {
//        super(nombre, identificacion);
//        this.pagoPorDia = pagoPorDia;
//        this.bonificacion = bonificacion;
//        this.diasTrabajados = diasTrabajados =0;
//    }

    public Normal(double pagoPorDia, double bonificacion, String nombre, long identificacion) {
        super(nombre, identificacion);
        this.pagoPorDia = pagoPorDia;
        this.bonificacion = bonificacion;
        this.diasTrabajados = 0;
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
        return (this.diasTrabajados*this.pagoPorDia)+this.bonificacion;    
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nEmpleado Normal \nPago por dia: "+this.pagoPorDia+"\nDias trabajados: "+this.diasTrabajados+
                "\nBonificacion: "+this.bonificacion+"\nSalario Final: "+this.calcularSalario()+"\n*********************";
    }
}
