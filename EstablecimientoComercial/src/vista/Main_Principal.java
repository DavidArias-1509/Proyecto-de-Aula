package vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Entrada;
import modelos.cuentas.*;
import modelos.employee.*;
import modelos.preparaciones.*;

/*
 * @author david
 */

public class Main_Principal {
    
    public static Inventario I1 = new Inventario();
    public static Mes mes = new Mes();
    
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
        Compra C1 = new Compra();
        C1.agregaACarrito(p2);
        C1.agregaACarrito(p1);
        System.out.println("Valor total de la Compra: "+C1.getValorTotal());
        C1.realizarCompra();
        v1.realizarVenta();
        System.out.println(C1.getFechaCompra());
        System.out.println("Balance del mes: "+mes.calcularBalance());
    }
    
    public static void ejecucionPrincipal(){
        char op;
        do{
            
        }while(op=='S');
    }
    
    public static int menuInicial(){
        System.out.println("1- Inventario");
        System.out.println("2- Registrar Venta");
        System.out.println("3- Registrar Compra");
        System.out.println("4- Registo de Asistencia");
        System.out.println("5- Persistir Informacion");
        System.out.println("6- Opciones de Balance");
        System.out.println("7- Funciones Especiales");
        System.out.println("8- Cerrar Programa");
        return Entrada.leerEntero("Selecione una alternativa: ");
    }
    
    public static int menuCompras(){
        System.out.println("1- Compra de Ingredientes");
        System.out.println("2- Productos Adicionales");
        System.out.println("3- Volver al Menu Anterior");
        return Entrada.leerEntero("Seleccione Una alternativa: ");
    }
    
    public static int opcionesBalance(){
        System.out.println("1- Balance por dia");
        System.out.println("2- Balance Mensual");
        System.out.println("3- Volver al Menu Anterior");
        return Entrada.leerEntero("Seleccione una alternativa: ");
    }
    
    public static int menuFuncionesAdmin(){
        System.out.println("1- Consultar detalle de Venta");
        System.out.println("2- Consultar detalle de Compra");
        System.out.println("3- Modificar Inventario");
        System.out.println("4- Datos Empleados");
        System.out.println("5- Volver al Menu Anterior");
        return Entrada.leerEntero("Seleccione una alternativa: ");
    }
}
