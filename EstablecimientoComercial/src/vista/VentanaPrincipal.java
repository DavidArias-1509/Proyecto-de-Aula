package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import jdialogs.*;

public class VentanaPrincipal extends JFrame implements MouseListener {
    private Container contenedor; 
    private JPanel op1, op2, op3, op4, op5, op6;
    private JLabel opcion1,opcion2,opcion3,opcion4,opcion5,opcion6;
    
    public VentanaPrincipal(String title){
        setTitle(title);
        setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.initComponents();
        
    }
    
    public void initComponents(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.titulo();
        this.crearPanelLateral();
        this.crearPanelCentral();
        this.funcionalidad();
    }
    
    public Font font1= new Font("Lucida Console", Font.BOLD, 18);
    public Font font2 = new Font("Lucida Console", Font.PLAIN, 18);
    
    public Color c1 = new Color(232,112,36);
    public Cursor c = new Cursor(HAND_CURSOR);
        
    public void titulo(){
        Font font3 = new Font("Lucida Console", Font.PLAIN, 20);
        Color c1 = new Color(232,112,36);
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(c1);
        panelTitle.setLayout(new GridLayout(2, 1, 1, 1));
        
        JLabel t1 = new JLabel("Restaurante: La Góndola");
        t1.setFont(font3);
        t1.setForeground(Color.BLACK);
        t1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel t2 = new JLabel("Sistema de Contabilidad");
        t2.setFont(font3);
        t2.setForeground(Color.BLACK);
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelTitle.add(t1, BorderLayout.EAST);
        panelTitle.add(t2, BorderLayout.EAST);
        
        this.contenedor.add(panelTitle, BorderLayout.NORTH);
    }
    
    public void crearPanelLateral(){
        JPanel panelGrid = new JPanel();
        panelGrid.setBackground(c1);
        panelGrid.setLayout(new GridLayout(2, 1, 3, 3));
        JPanel subPanelTitulo = new JPanel();
        subPanelTitulo.setBackground(c1);
        subPanelTitulo.setLayout(new GridLayout(2,1,1,1));
        JLabel logo = new JLabel();
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png")));
        JLabel title = new JLabel("LA GÓNDOLA");
        title.setForeground(Color.black);
        title.setFont(new Font("Wide Latin", 0, 18));
        subPanelTitulo.add(logo);
        subPanelTitulo.add(title);
        
        panelGrid.add(subPanelTitulo, BorderLayout.NORTH);
        panelGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panelGrid, BorderLayout.WEST);
    }
    
    public void crearPanelCentral(){
        JPanel subPanelOpciones = new JPanel();
        subPanelOpciones.setBackground(c1);
        subPanelOpciones.setLayout(new GridLayout(7,1,1,1));
        subPanelOpciones.setCursor(c);
        //Inventario
        this.op1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion1 = new JLabel("Inventario");
        this.opcion1.setFont(font2);
        this.opcion1.setForeground(Color.BLACK);
        this.op1.add(opcion1);
        //Resgistrar Venta
        this.op2=new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion2 = new JLabel("Registrar Venta");
        opcion2.setFont(font2);
        opcion2.setForeground(Color.BLACK);
        this.op2.add(opcion2);
        //RegistrarCompra
        this.op3=new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion3 = new JLabel("Registrar Compra");
        opcion3.setFont(font2);
        opcion3.setForeground(Color.BLACK);
        this.op3.add(opcion3);
        //Registro de Asistencia
        this.op4=new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion4 = new JLabel("Registro de Asistencia");
        opcion4.setFont(font2);
        opcion4.setForeground(Color.BLACK);
        this.op4.add(opcion4);
        //Registro de Balance
        this.op5=new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion5 = new JLabel("Opciones de Balance");
        opcion5.setFont(font2);
        opcion5.setForeground(Color.BLACK);
        this.op5.add(opcion5);
        //Funciones Especiales
        this.op6=new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion6 = new JLabel("Funciones Especiales");
        opcion6.setFont(font2);
        opcion6.setForeground(Color.BLACK);
        this.op6.add(opcion6);
        
        subPanelOpciones.add(this.op1);
        subPanelOpciones.add(this.op2);
        subPanelOpciones.add(this.op3);
        subPanelOpciones.add(this.op4);
        subPanelOpciones.add(this.op5);
        subPanelOpciones.add(this.op6);
        subPanelOpciones.add(new JPanel());
        
        this.contenedor.add(subPanelOpciones, BorderLayout.CENTER);
    }
    
    public void funcionalidad(){
        op1.addMouseListener(this);
        op2.addMouseListener(this);
        op3.addMouseListener(this);
        op4.addMouseListener(this);
        op5.addMouseListener(this);
        op6.addMouseListener(this);
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == this.op1){
              JOptionPane.showMessageDialog(null, opcion1.getText());
            try {
                JDInventario dialog = new JDInventario(null,  "Inventario", true);
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource() == this.op2){
            JOptionPane.showMessageDialog(null, opcion2.getText());
            JDRegistroVenta dialog = new JDRegistroVenta(null, "Registro Venta", true);
        }else if(e.getSource() == this.op3){
            JOptionPane.showMessageDialog(null, opcion3.getText());
            JDRegistroCompra dialog = new JDRegistroCompra(null, "Registro Compra", true);
        }else if(e.getSource() == this.op4){
            JOptionPane.showMessageDialog(null, opcion4.getText());
            JDAsistencia dialog = new JDAsistencia(null, "Registro de Asistencia", true);
        }else if(e.getSource() == this.op5){
            JOptionPane.showMessageDialog(null, opcion5.getText());
            JDBalance dialog = new JDBalance(null, "Opciones de Balance", true);
        }else if(e.getSource() == this.op6){
            JOptionPane.showMessageDialog(null, opcion6.getText());
            JDFuncionesEspeciales dialog = new JDFuncionesEspeciales(null, "Funciones Especiales", true);
        }else{
            
        }
       
     }  

    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       }

    @Override
    public void mouseEntered(MouseEvent e) {
       if(e.getSource() == this.op1){
             this.op1.setBackground(c1);
             this.opcion1.setForeground(Color.WHITE);
             this.opcion1.setFont(font1);
        }else if(e.getSource() == this.op2){
            this.op2.setBackground(c1);
             this.opcion2.setForeground(Color.WHITE);
             this.opcion2.setFont(font1);
        }else if(e.getSource() == this.op3){
            this.op3.setBackground(c1);
             this.opcion3.setForeground(Color.WHITE);
             this.opcion3.setFont(font1);
        }else if(e.getSource() == this.op4){
            this.op4.setBackground(c1);
             this.opcion4.setForeground(Color.WHITE);
             this.opcion4.setFont(font1);
        }else if(e.getSource() == this.op5){
            this.op5.setBackground(c1);
             this.opcion5.setForeground(Color.WHITE);
             this.opcion5.setFont(font1);
        }else if(e.getSource() == this.op6){
            this.op6.setBackground(c1);
             this.opcion6.setForeground(Color.WHITE);
             this.opcion6.setFont(font1);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.op1){
             this.op1.setBackground(Color.white);
             this.opcion1.setForeground(Color.BLACK);
             this.opcion1.setFont(font2);
        }else if(e.getSource() == this.op2){
            this.op2.setBackground(Color.white);
             this.opcion2.setForeground(Color.BLACK);
             this.opcion2.setFont(font2);
        }else if(e.getSource() == this.op3){
            this.op3.setBackground(Color.white);
             this.opcion3.setForeground(Color.BLACK);
             this.opcion3.setFont(font2);
        }else if(e.getSource() == this.op4){
            this.op4.setBackground(Color.white);
             this.opcion4.setForeground(Color.BLACK);
             this.opcion4.setFont(font2);
        }else if(e.getSource() == this.op5){
            this.op5.setBackground(Color.white);
             this.opcion5.setForeground(Color.BLACK);
             this.opcion5.setFont(font2);
        }else if(e.getSource() == this.op6){
            this.op6.setBackground(Color.white);
             this.opcion6.setForeground(Color.BLACK);
             this.opcion6.setFont(font2);
        }
    }
    
}
