package vista;

import javax.swing.JOptionPane;


/**
 *
 * @author david
 */
public class Main_Principal {
    
   
    public static void main(String[] args) {
       char cn='S';
        while(cn=='S'){
            int op=Integer.parseInt(JOptionPane.showInputDialog(null,"1- Facturar\n2- platos\n3-Revisar mesa disponible\n4-cerrar"));       
            switch(op){
                case 1: JOptionPane.showMessageDialog( null, "Menu");break;
                case 2: JOptionPane.showMessageDialog( null, "Platos");break;
                case 3: JOptionPane.showMessageDialog( null, "Mesas");break;
                case 4: JOptionPane.showMessageDialog( null, "Bye");cn='N';break;  
            }
        }
    }
    
    
}
