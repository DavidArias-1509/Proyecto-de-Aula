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
       return input.next();
   }
   
   public static char leerCaracter(String label){
       System.out.println(label);
       return Character.toUpperCase(input.next().charAt(0));
   }
  
   public static LocalDate leerFecha(String label){
        System.out.println(label + " (dd/MM/yyyy):");
        String fecha = input.next();
        return LocalDate.parse(fecha, formatter);
   }
}
