package vista;

import Modelos.*;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class Main_Principal {
    
   
    public static void main(String[] args) {
        Cliente C001 = new Cliente("Juan Antonio", 23456897, 3004567892L, "example@gmail.com");
        C001.setDeudas(234560);
         //System.out.println(C001.toString()); 
         
         //creando distribuidores
         
        Distribuidor D001 = new Distribuidor("1235468","Arroces S.A.S","3148988546",100000);
        Distribuidor D002 = new Distribuidor("2215578","Frutiño","3148589646",150000);
        Distribuidor D003 = new Distribuidor("8265366","Magui COP","3148789546",200000);
        
        ArrayList<Distribuidor> distribuidor = new ArrayList();
        distribuidor.add(D003);
        distribuidor.add(D002);
        distribuidor.add(D001);
        
        Producto P001 = new Producto("Arroz Diana P", 1234, 30,12300);
        P001.setDescripcion("3Kg de Arroz seleccionado de alta calidad \nContiene vitaminas y minerales");
        
        Producto P002 = new Producto("Magui", 1432, 30,500);
        P001.setDescripcion("Consume de pollo");
        
        Producto P003 = new Producto("Frutiño", 1243, 30,600);
        P001.setDescripcion("Bebida saborizante instantanea");
        //System.out.println(P001.toString());
        
        Empleado E001 = new Empleado("Francisco Jose", 23457897,3226763839L,"frjose@hotmail.com","Masculino","Calle 56",43);
        E001.setSalarioBase(3456789);
        //System.out.println(E001.toString());
        
        ArrayList<Producto> listaProductos = new ArrayList();
        P002.setCantidadVenta(10);
        P003.setCantidadVenta(31);
        listaProductos.add(P003);
        listaProductos.add(P002);
        
        ArrayList<Producto> L002 = new ArrayList();
        P001.setCantidadVenta(4);
        P002.setCantidadVenta(5);
        P003.setCantidadVenta(3);
        L002.add(P003);
        L002.add(P002);
        L002.add(P001);
        
        Venta V001 = new Venta(C001,E001,10,LocalDate.now(),12345L);
        P001.setCantidadVenta(5);
        V001.registrarProducto(P001);
        V001.registrarProducto(listaProductos);
        //Se llama el metodo para imprimir un recibo de compra
        //imprimirFactura(V001);
        
        Venta V002 = new Venta(C001, E001,5,LocalDate.now(),12346L);
        V002.registrarProducto(L002);
        
        ArrayList<Venta> sales = new ArrayList();
        sales.add(V001);
        sales.add(V002);
        
        Balance agosto = new Balance("Julio-Agosto",sales, null, null);
        
        //System.out.println(P001.toString());
        
        Balance septiembre = new Balance();
        septiembre.setPeriodo("Agosto-septiembre");
        septiembre.setSalrios(4985760);
        septiembre.setDeudas(12345850);
        septiembre.setProducido(17214560);
        System.out.println(septiembre.toString());
        
    }
    
    public static void imprimirFactura(Venta v){
        System.out.println("Vendedor: "+ v.getVendedor().getNombre());
        System.out.println("Cliente: "+ v.getComprador().getNombre());
        if(v.getArticulo()!=null){
            for (Producto p : v.getArticulo()){
                System.out.println("-------------------------");
                System.out.println("Codigo: " + p.getCodigo());
                System.out.println("producto: " + p.getNombre());
                System.out.println("Precio: "+ p.getPrecio());
                System.out.println("Cantidad: "+ p.getCantidadVenta());
            }
        }else{
            System.out.println("No hay articulos");
        }
        
        System.out.println("Fecha de venta: "+ v.getFechaVenta());
        System.out.println("Descuento: " + v.getDescuento()+ "%");
        System.out.println("Total a Pagar: " + v.getValorVenta());
        System.out.println("Puntos ganados: " + v.getPuntosVenta());
    }
}
