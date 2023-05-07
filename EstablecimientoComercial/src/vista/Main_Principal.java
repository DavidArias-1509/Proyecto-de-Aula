package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.cuentas.Producto;
import modelos.preparaciones.*;


/**
 *
 * @author david
 */
public class Main_Principal {
    
   
    public static void main(String[] args) {
         List<Producto> inventario = new ArrayList();
         Producto p1 = new Producto("tomate", 1000); inventario.add(p1);
         Producto p2 = new Producto("pasta", 500); inventario.add(p2);
         
         Receta r1 = new Receta("Pastas con tomate");
         Ingrediente i1 = new Ingrediente ("tomate", 5, 50);r1.agregarIngrediente(i1);
         Ingrediente i2 = new Ingrediente("pasta",3, 100);r1.agregarIngrediente(i2);
         
         System.out.println("El precio es: "+r1.calcularPrecio());
         char encontro='N';
         for(Ingrediente I : r1.getIngredientes() ){
             for(Producto p : inventario){
                 if(I.getNombre().equalsIgnoreCase(p.getNombre())){
                     if(I.getCantidad()>p.getCnatidadDisponible()){
                         encontro='S';
                         break;
                     }
                 }
             }
         }
         
        if(encontro=='S'){
            System.out.println("No se puede preparar la receta");
        }else{
            System.out.println("La receta se puede preparar");
            for(Ingrediente I : r1.getIngredientes() ){
             for(Producto p : inventario){
                 if(I.getNombre().equalsIgnoreCase(p.getNombre())){
                        int cantidad = p.getCnatidadDisponible()-I.getCantidad();
                        p.setCnatidadDisponible(cantidad);
                        System.out.println("La nueva cantidad de "+p.getNombre()+" es: "+p.getCnatidadDisponible());
                 }
             }
         }
        }
    }
    
}
