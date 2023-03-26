package vista;

import Modelos.*;
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
        
    }
}
