package vista;

import Modelos.*;
/**
 *
 * @author david
 */
public class Main_Principal {
    
   
    public static void main(String[] args) {
        Cliente B001 = new Cliente("Juan Antonio", 23456897, 3004567892L, "example@gmail.com");
        B001.setDeudas(234560);
        
        System.out.println(B001.toString()); 
        
        Producto Arroz = new Producto("Arroz Diana P", 1234, 30);
        Arroz.setDescripcion("Arroz seleccionado de alta calidad \n Contiene vitaminas y minerales");
    }
}
