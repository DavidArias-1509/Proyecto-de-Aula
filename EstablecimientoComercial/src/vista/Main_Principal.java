package vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.cuentas.*;
import modelos.employee.*;
import modelos.preparaciones.*;

/*
 * @author david
 */
public class Main_Principal {
    
    public static Inventario I1 = new Inventario();
    public static void main(String[] args) {
         List<Producto> inventario = new ArrayList();
         Producto p1 = new Producto("tomate", 1000,5,"Vegetal"); inventario.add(p1);
         Producto p2 = new Producto("pasta", 50,3,"Masa"); inventario.add(p2);
         
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
        
        List<Empleado> personal = new ArrayList();
        Normal e1 = new Normal(12_000, 30_000, 20, "Juan Alvarez", 1000456); personal.add(e1);
        Administrador admin  = new Administrador(1235000, 367000, 150000, "Marcos", 12341121);
        personal.add(admin);
        double nomina=0;
        for(Empleado e : personal){
            System.out.println(e);
            nomina += e.calcularSalario();
        }
        System.out.println("El valor total de la nomina es: "+nomina);
        

        ArrayList <Receta> plato = new ArrayList();
            Venta v1 = new Venta(plato,e1);
            v1.agregarReceta(r1);
            System.out.println("Total de la venta es: "+v1.calcularPrecio());

        
        Dia nuevo = new Dia(LocalDate.of(2023, 5, 7));
        Compras C1 = new Compras();
        C1.agregaACarrito(p2);
        C1.agregaACarrito(p1);
        System.out.println("Valor total de la Compra"+C1.getValorTotal());
    }
    
}
