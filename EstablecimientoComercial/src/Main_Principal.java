import java.util.Scanner;

/**
 *
 * @author david
 */
public class Main_Principal {
    Scanner reader = new Scanner(System.in);
   
    public static void main(String[] args) {
        int opcion;
        System.out.println("Empresa S.A.S.");
        opcion=Menu1();
        switch(opcion){
            case 1: //regisrarVenta();
            case 2: //registarCliente();
            case 3: //verInventario();
            case 4: //Admin();
            case 5: //salir
        }
    }
    
    public static int Menu1() {
        Scanner read = new Scanner(System.in);  
        int option=0;
        System.out.println("1- Registar Venta \n");
        System.out.println("2- Registrar Cliente \n");
        System.out.println("3- Ver inventario \n");
        System.out.println("4- Administacion \n");
        System.out.println("5- Salir - Cerrar \n");
        System.out.println("Seleccione una alternativa: >");
        do{
            option=read.nextInt();
        }while((option<0)&&(option>5));
        in.close();
        return option;
    }

    public static void Admin(){
        
    }
}

