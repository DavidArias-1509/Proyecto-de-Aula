package vista;

import Modelos.*;
import java.time.LocalDate;
/**
 *
 * @author david
 */
public class Main_Principal {
    
   
    public static void main(String[] args) {
        Cliente C001 = new Cliente("Juan Antonio", 23456897, 3004567892L, "example@gmail.com");
        C001.setDeudas(234560);
         System.out.println(C001.toString()); 
        
        Producto P001 = new Producto("Arroz Diana P", 1234, 30,12300);
        P001.setDescripcion("3Kg de Arroz seleccionado de alta calidad \nContiene vitaminas y minerales");
        System.out.println(P001.toString());
        
        Empleado E001 = new Empleado("Francisco Jose", 23457897,3226763839L,"frjose@hotmail.com","Masculino","Calle 56",43);
        E001.setSalarioBase(3456789);
        System.out.println(E001.toString());
        
        Venta V001 = new Venta(C001,E001,10,LocalDate.now());
        V001.registrarProducto(P001);
        imprimirFactura(V001);
    }
    
    public static void imprimirFactura(Venta v){
        System.out.println("Vendedor: "+ v.getVendedor());
        System.out.println("Cliente: "+ v.getComprador());
        for (Producto p : v.getArticulo()){
            System.out.println("-------------------------");
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("producto: " + p.getNombre());
            System.out.println("Precio: "+ p.getPrecio());
        }
        
        System.out.println("Fecha de venta: "+ v.getFechaVenta());
        System.out.println("Descuento: " + v.getDescuento()+ "%");
        System.out.println("Total a Pagar: " + v.getValorVenta());
        System.out.println("Puntos ganados: " + v.getPuntosVenta());
    }
}
