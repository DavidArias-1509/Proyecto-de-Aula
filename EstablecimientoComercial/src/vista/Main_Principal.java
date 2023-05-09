package vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public static List<Empleado> personal = new ArrayList();
    public static List<Receta> libroReceta = new ArrayList();
    
    public static void main(String[] args) {
         Producto p1 = new Producto("tomate", 1000,5,"Vegetal"); I1.agregarItem(p1);
         Producto p2 = new Producto("pasta", 50,3,"Masa"); I1.agregarItem(p2);
    
         Receta r1 = new Receta("Pastas con tomate");
         Ingrediente i1 = new Ingrediente ("tomate", 5, 50);r1.agregarIngrediente(i1);
         Ingrediente i2 = new Ingrediente("pasta",3, 100);r1.agregarIngrediente(i2);
         libroReceta.add(r1);
         System.out.println("El precio es: "+r1.calcularPrecio());
         char encontro='N';
         for(Ingrediente I : r1.getIngredientes() ){
             Producto p = I1.getItem().get(p1.getNombre());
            if(I.getNombre().equalsIgnoreCase(p.getNombre())){
                if(I.getCantidad()>p.getCnatidadDisponible()){
                    encontro='S';
                    break;
                }
            }
         }
         
        if(encontro=='S'){
            System.out.println("No se puede preparar la receta");
        }else{
            System.out.println("La receta se puede preparar");
            for(Ingrediente I : r1.getIngredientes() ){
                 Producto p = I1.getItem().get(p1.getNombre());            
                 if(I.getNombre().equalsIgnoreCase(p.getNombre())){
                        int cantidad = p.getCnatidadDisponible()-I.getCantidad();
                        p.setCnatidadDisponible(cantidad);
                        System.out.println("La nueva cantidad de "+p.getNombre()+" es: "+p.getCnatidadDisponible());
                 }
             }
        }
        
        Normal e1 = new Normal(12_000, 30_000, "Juan Alvarez", 1000456L); personal.add(e1);
        Administrador admin  = new Administrador(1235000, 367000, 150000, "Marcos", 12341121);
        Cliente c1 = new Cliente("Maria", "blablabla@gmail.com", 12314493L);
        
        personal.add(admin);
        double nomina=0;
        for(Empleado e : personal){
            System.out.println(e);
            nomina += e.calcularSalario();
        }
        System.out.println("El valor total de la nomina es: "+nomina);
        


        //ArrayList <Receta> plato = new ArrayList();
            Venta v1 = new Venta(e1,c1);
            v1.agregarPlato(r1);
            System.out.println("Total de la venta es: "+v1.calcularPrecio());

        
        Dia nuevo = new Dia(LocalDate.of(2023, 5, 7));
        nuevo.registarAsistencia(e1);
        mes.agregarDia(nuevo);
        Compra C1 = new Compra();
        C1.agregaACarrito(p2);
        C1.agregaACarrito(p1);
        System.out.println("Valor total de la Compra: "+C1.getValorTotal());
        C1.realizarCompra();
        v1.realizarVenta();
        System.out.println(C1.getFechaCompra());
        System.out.println("Balance del mes: "+mes.mesBalance(5, 2023));
        System.out.println("Valance del dia 7 del mes 5: "+ nuevo.calcularBalance());

        ejecucionPrincipal();
    }
    
    public static void ejecucionPrincipal(){
        char op='S';
            
       while(op=='S'){
           int option = menuInicial();
            switch(option){
                case 1: mostrarInventario();
                    break;
                   
               case 2:
                   Venta.RegistroVenta();
                    break;
                   
               case 3:
                    break;
                   
               case 4: registroAsistencia();
                    break;
                   
               case 5: persistirInformacion();
                    break;
                   
               case 6: balances();
                    break;
                   
               case 7: funcionesAdicionales();
                    break;
                   
               case 8: op='N';
                    break;
                   
               default: System.out.println("Valor inesperado: Intente otra vez");
            }
       }
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
        System.out.println("4- Eliminar Venta");
        System.out.println("5- Eliminar Compra");
        System.out.println("6- Datos Empleados");
        System.out.println("7- Registrar Empleado");
        System.out.println("8- Volver al Menu Anterior");
        return Entrada.leerEntero("Seleccione una alternativa: ");
    }
    
    public static boolean validar(String user, String password){
        String usuario="";
        String contrasena="";
        boolean confirmar = false;
        if((usuario.equals(user))&&(contrasena.equals(password))){
            confirmar = true;
        }
        return confirmar;
    }
    
    public static void funcionesAdicionales(){
        boolean confirm=false;
         char romper='N';
         int opc;
        do{
            confirm=validar(Entrada.leerString("Usuario: "), Entrada.leerString("Contrasena: "));
            if(confirm==false){
                System.out.println("Error con el usuario o la contrasena: Verfique los datos");
                romper = Entrada.leerCaracter("Desea volver al menu anterior? (S/N): ");
            }
          }while((false==confirm)||(romper=='N'));
         
        if(confirm==true){
            char cn='S';
            while(cn=='S'){
                opc=menuFuncionesAdmin();
                switch(opc){
                        case 1: verDetalleVenta();
                            break;
                        case 2:verDetalleCompra();
                            break;
                        case 3: modificarInventario();
                            break;
                        case 4:eliminarVenta();
                            break;
                        case 5:eliminarCompra();
                            break;
                        case 6:listaPersonal();
                            break;
                        case 7: agregarEmpleado();
                                break;
                        case 8:cn='N';
                            break;
                         
                        default: System.out.println("Valor inesperado: Intente otra vez");
                        
                 }
            }
            
        }
    }
    
   
    
    public static void agregarEmpleado(){
        Empleado e;
        char op='S', encontro='N';
        System.out.println("Registro de empleados");
        long id;
        while(op=='S'){
            do{
                id = Entrada.leerLong("Cedula: ");
                if(personal==null){
                   encontro='N'; 
                }else{
                    for(Empleado c : personal){
                        if(c.getIdentificacion()==id){
                            System.out.println("Ya hay un empleado con esa cedula");
                            encontro='S';
                            System.out.println("Intente otra vez");
                            break;
                        }
                    }
                }
            }while(encontro=='S');
            
            String name =Entrada.leerString("Nombre");        
            char tipo = Entrada.leerCaracter("Admin (A) o Normal (N): ");    

            do{
                tipo = Entrada.leerCaracter("Admin (A) o Normal (N): ");
                if((tipo!='A')&&(tipo!='N')){
                    System.out.println("Valor inesperado: Intente otra vez");
                }
            }while((tipo!='A')&&(tipo!='N'));
            if(tipo=='A'){
                double salarioBase = Entrada.leerDouble("Salario base: ");
                double auxilios = Entrada.leerDouble("Auxilios: ");
                double bonificacion = Entrada.leerDouble("Bonificacion: ");
                e = new Administrador(salarioBase, auxilios, bonificacion, name, id);
            }else{
                double pagoPorDia = Entrada.leerDouble("Pago por dia: ");
                double bonificacion = Entrada.leerDouble("Bonificacion: ");
                e = new Normal(pagoPorDia, bonificacion, name, id);
            }
            personal.add(e);
            do{
                op=Entrada.leerCaracter("Desea Agregar un empleado mas? (S/N) :");
            }while((op!='N')&&(op!='S'));
             
        }
    }
    
    public static void mostrarInventario(){
        System.out.println("Inventario de Ingredientes");
        if(I1==null){
            System.out.println("Al parecer hay Ingredientes");
        }else{
            System.out.println("Ingrediente             Cantidad Disponible");
            Iterator<String> c = I1.getItem().keySet().iterator();
            while(c.hasNext()){
                String key = c.next();
                System.out.println(I1.getItem().get(key));
            }
            System.out.println("\nNO hay mas ingredientes");
            System.out.println("********************");
        }
    }

    private static void verDetalleVenta() {
       LocalDate buscar = Entrada.leerFecha("Dia de la venta: ");
       for(Dia d : mes.getDias()){
           if(buscar.equals(d.getFecha())){
               System.out.println("Dia econtrado:");
               String code = Entrada.leerString("Codigo de la venta: ");
              for(Venta v : d.getVentas()){
                  if(code.equals(v.getCodigoVenta())){
                      v.detalle();
                  }
              }
           }
       }
    }

    private static void verDetalleCompra() {
         LocalDate buscar = Entrada.leerFecha("Dia de la compra: ");
       for(Dia d : mes.getDias()){
           if(buscar.equals(d.getFecha())){
               System.out.println("Dia econtrado:");
               String code = Entrada.leerString("Codigo de la compra: ");
              for(Compra c : d.getCompras()){
                  if(code.equals(c.getCodigoCompra())){
                      c.detalle();
                  }
              }
           }
       }
    }

    private static void modificarInventario() {
        
        char opc = Entrada.leerCaracter("Desea agregar(A) o eliminar(E): ");
          String ingrediente = Entrada.leerString("Nombre del ingrediente: ");
          int cantidad;
          if(opc=='A'){
              cantidad=Entrada.leerEntero("Cantidad para agregar: ");
          }else{
              cantidad=Entrada.leerEntero("Cantidad para eliminar: ");
          }
          Iterator<String> c = I1.getItem().keySet().iterator();
        while(c.hasNext()){
            String key = c.next();
            if(ingrediente.equals(I1.getItem().get(key).getNombre())){
                System.out.println("Ingrediente encontrado ");
                if(opc=='A'){
                    int nuevo = I1.getItem().get(key).getCnatidadDisponible()+cantidad;
                    I1.getItem().get(key).setCnatidadDisponible(nuevo);
                }else{
                    int nuevo = I1.getItem().get(key).getCnatidadDisponible()-cantidad;
                    I1.getItem().get(key).setCnatidadDisponible(nuevo);
                }
                System.out.println("Nueva cantidad: "+I1.getItem().get(key).getCnatidadDisponible());
            }
        }       
    }

    private static void eliminarVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void eliminarCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void listaPersonal() {
        System.out.println("Lista de Personal");
        System.out.println("Nombre-Identificacion");
        for(Empleado e : personal){
            System.out.println(e.getNombre()+"-"+e.getIdentificacion());
        }
    }

    private static void persistirInformacion() {
        System.out.println("Aun no disponible ");
    }

    private static void balances() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void registroAsistencia() {
        
    }
    
    
}


