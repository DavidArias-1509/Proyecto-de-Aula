/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class VentanaPrincipal extends JFrame implements MouseListener {
    private Container contenedor; 
    
    private JLabel opcion1,opcion2,opcion3,opcion4,opcion5,opcion6,opcion7; 
    
    public VentanaPrincipal(String title){
        setTitle(title);
        setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.initComponents();
        setSize(500,500);
        
    }
    
    public void initComponents(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.titulo();
        this.crearPanelLateral();
        this.funcionalidad();
    }
    
    public Font font1= new Font("Lucida Console", Font.BOLD, 18);
    public Font font2 = new Font("Lucida Console", Font.PLAIN, 18);
    
    public void titulo(){
        Font font3 = new Font("Lucida Console", Font.PLAIN, 20);
        Color c1 = new Color(232,112,36);
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(c1);
        panelTitle.setLayout(new GridLayout(2, 1, 1, 1));
        JLabel t1 = new JLabel("Restaurante: La Góndola");
        t1.setFont(font3);
        t1.setForeground(Color.BLACK);
        JLabel t2 = new JLabel("Sistema de Contabilidad");
        t2.setFont(font3);
        t2.setForeground(Color.BLACK);
        panelTitle.add(t1, BorderLayout.EAST);
        panelTitle.add(t2, BorderLayout.EAST);
        this.contenedor.add(panelTitle, BorderLayout.NORTH);
    }
   
    public void crearPanelLateral(){
        Color c1 = new Color(232,112,36);
        Cursor c = new Cursor(HAND_CURSOR);
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
        
        JPanel subPanelOpciones = new JPanel();
        subPanelOpciones.setBackground(c1);
        subPanelOpciones.setLayout(new GridLayout(7,1,1,1));
        subPanelOpciones.setCursor(c);
        //Inventario
        this.opcion1 = new JLabel("Inventario");
        opcion1.setFont(font2);
        opcion1.setForeground(Color.BLACK);
        //Resgistrar Venta
        this.opcion2 = new JLabel("Registrar Venta");
        opcion2.setFont(font2);
        opcion2.setForeground(Color.BLACK);
        //RegistrarCompra
        this.opcion3 = new JLabel("Registrar Compra");
        opcion3.setFont(font2);
        opcion3.setForeground(Color.BLACK);
        //Registro de Asistencia
        this.opcion4 = new JLabel("Registro de Asistencia");
        opcion4.setFont(font2);
        opcion4.setForeground(Color.BLACK);
        //Registro de Balance
        this.opcion5 = new JLabel("Opciones de Balance");
        opcion5.setFont(font2);
        opcion5.setForeground(Color.BLACK);
        this.opcion6 = new JLabel("Funciones Especiales");
        opcion6.setFont(font2);
        opcion6.setForeground(Color.BLACK);
        this.opcion7 = new JLabel("Persistir");
        opcion7.setFont(font2);
        opcion7.setForeground(Color.BLACK);
        
        subPanelOpciones.add(opcion1);
        subPanelOpciones.add(opcion2);
        subPanelOpciones.add(opcion3);
        subPanelOpciones.add(opcion4);
        subPanelOpciones.add(opcion5);
        subPanelOpciones.add(opcion6);
        subPanelOpciones.add(opcion7);
        
        panelGrid.add(subPanelTitulo, BorderLayout.NORTH);
        panelGrid.add(subPanelOpciones, BorderLayout.CENTER);
        
        panelGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panelGrid, BorderLayout.WEST);
    }
    
    public void funcionalidad(){
        opcion1.addMouseListener(this);
        opcion2.addMouseListener(this);
        opcion3.addMouseListener(this);
        opcion4.addMouseListener(this);
        opcion5.addMouseListener(this);
        opcion6.addMouseListener(this);
        opcion7.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel) {
            JLabel label = (JLabel) e.getSource();
            label.setForeground(Color.WHITE); // Cambiar el color del texto al entrar
            JOptionPane.showMessageDialog(null, label.getText());
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
       if (e.getSource() instanceof JLabel) {
            JLabel label = (JLabel) e.getSource();
            label.setForeground(Color.WHITE); // Cambiar el color del texto al entrar
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JLabel) {
            JLabel label = (JLabel) e.getSource();
            label.setForeground(Color.BLACK); // Restaurar el color del texto al salir
        } 
    }
}
