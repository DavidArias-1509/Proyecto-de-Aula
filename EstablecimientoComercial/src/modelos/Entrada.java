package modelos;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Entrada {
    private static  Scanner input = new Scanner(System.in);
   private static  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   
   public static double leerDouble(String label){
       System.out.println(label);
       return input.nextDouble();
   }
   
   public static int leerEntero(String label){
       System.out.println(label);
       return input.nextInt();
   }
   
   public static String leerString(String label){
       System.out.println(label);
       return input.nextLine();
       String str = input.nextLine();
       //try{
       String bug = input.next();
       //}
       return str;
   }
   
   public static char leerCaracter(String label){
       System.out.println(label);
       return Character.toUpperCase(input.nextLine().charAt(0));
   }
  
   public static LocalDate leerFecha(String label){
        System.out.println(label + " (dd/MM/yyyy):");
        String fecha = input.nextLine();
        return LocalDate.parse(fecha, formatter);
   }
   
   public static long leerLong(String label){
        System.out.println(label);
        long num = input.nextLong();
        input.nextLine();
        return num;
    }
  
}
