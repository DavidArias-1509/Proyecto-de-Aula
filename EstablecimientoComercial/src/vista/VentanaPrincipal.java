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
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import jdialogs.JDInventario;

public class VentanaPrincipal extends JFrame implements MouseListener {
    private Container contenedor; 
    
    private JPanel contenedorVentana;
    private JLabel opcion1,opcion2,opcion3,opcion4,opcion5,opcion6;
    private JPanel op1, op2, op3, op4, op5, op6;
    private JPanel panelCentral;
    
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
        panelTitle.setLayout(new BorderLayout());
        JLabel t1 = new JLabel("Restaurante: La Góndola");
        t1.setFont(font3);
        t1.setHorizontalAlignment(SwingConstants.CENTER);
        t1.setForeground(Color.BLACK);
        JLabel t2 = new JLabel("Sistema de Contabilidad");
        t2.setFont(font3);
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        t2.setForeground(Color.BLACK);
        panelTitle.add(t1, BorderLayout.NORTH);
        panelTitle.add(t2, BorderLayout.SOUTH);
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
    
    public void inventario(){
        JPanel cont = new JPanel();
        cont.setLayout(new GridLayout(2,1,1,1));
        cont.setBackground(new Color(255,255,255));
        JLabel tituloTabla = new JLabel();
        tituloTabla.setText("Productos Disponibles");
        tituloTabla.setForeground(Color.BLACK);
        tituloTabla.setFont(font2);
        cont.add(tituloTabla);
        this.contenedorVentana.add(cont);
    }
    
    public void crearPanelCentral(){
        Border border = BorderFactory.createLineBorder(c1, 1);
        JPanel subPanelOpciones = new JPanel();
        subPanelOpciones.setBackground(c1);
        subPanelOpciones.setLayout(new GridLayout(8,1,2,1));
        subPanelOpciones.setCursor(c);
        //Inventario
        this.op1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion1 = new JLabel("Inventario");
        opcion1.setFont(font2);
        opcion1.setForeground(Color.BLACK);
        op1.add(opcion1);
        //Resgistrar Venta
        this.op2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion2 = new JLabel("Registrar Venta");
        opcion2.setFont(font2);
        opcion2.setForeground(Color.BLACK);
        op2.add(opcion2);
        //RegistrarCompra
        this.op3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion3 = new JLabel("Registrar Compra");
        opcion3.setFont(font2);
        opcion3.setForeground(Color.BLACK);
        op3.add(opcion3);
        //Registro de Asistencia
        this.op4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion4 = new JLabel("Registro de Asistencia");
        opcion4.setFont(font2);
        opcion4.setForeground(Color.BLACK);
        op4.add(opcion4);
        //Registro de Balance
        this.op5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion5 = new JLabel("Opciones de Balance");
        opcion5.setFont(font2);
        opcion5.setForeground(Color.BLACK);
        op5.add(opcion5);
        //Funciones especiales
        this.op6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.opcion6 = new JLabel("Funciones Especiales");
        opcion6.setFont(font2);
        opcion6.setForeground(Color.BLACK);
        op6.add(opcion6);
        subPanelOpciones.setBorder(border);
        
        subPanelOpciones.add(op1);
        subPanelOpciones.add(op2);
        subPanelOpciones.add(op3);
        subPanelOpciones.add(op4);
        subPanelOpciones.add(op5);
        subPanelOpciones.add(op6);
        subPanelOpciones.add(new JPanel());
        
        this.contenedor.add(subPanelOpciones, BorderLayout.CENTER);
        
    }
    
    public void funcionalidad(){
        opcion1.addMouseListener(this);
        opcion2.addMouseListener(this);
        opcion3.addMouseListener(this);
        opcion4.addMouseListener(this);
        opcion5.addMouseListener(this);
        opcion6.addMouseListener(this);
         }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == this.opcion1){
              JOptionPane.showMessageDialog(null, opcion1.getText());
              JDInventario dialog = new JDInventario(null,  "Inventario", true);
        }else{
            JOptionPane.showMessageDialog(null, "Opcion");
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
            label.setBackground(Color.BLACK);
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
