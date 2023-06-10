package jdialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JDRegistroVenta extends JDialog {
    private JLabel Titulo;
    private Container contenedor;  
    
    private JLabel fecha, codVenta, empleado, idEmpleado, nombre, cliente, idCliente, nombreCliente, email;
    private JTextField cFecha, cCodVenta, cIdEmpleado, cNombre, cIdCliente, cNombreCliente, cEmail;

    public JDRegistroVenta(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
    }
    
     public void initComponents(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.crear();
        this.setSize(400,400);
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
     
     public void crear(){
        this.panelTitulo();
        this.crearPanelLateral();
        this.crearPanel();
    }
    
     public Font font1= new Font("Lucida Console", Font.BOLD, 18);
    public Font font2 = new Font("Lucida Console", Font.PLAIN, 18);
    
    public Color c1 = new Color(232,112,36);
    
    public void panelTitulo(){
        Font font3 = new Font("Lucida Console", Font.PLAIN, 20);
        Color c1 = new Color(232,112,36);
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(c1);
        panelTitle.setLayout(new GridLayout(3, 1, 1, 1));
        
        JLabel t1 = new JLabel("Restaurante: La Góndola");
        t1.setFont(font3);
        t1.setForeground(Color.BLACK);
        t1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel t2 = new JLabel("Sistema de Contabilidad");
        t2.setFont(font3);
        t2.setForeground(Color.BLACK);
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel t3 = new JLabel("Registro de Ventas");
        t3.setFont(font3);
        t3.setForeground(Color.BLACK);
        t3.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelTitle.add(t1);
        panelTitle.add(t2);
        panelTitle.add(t3);
        
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
    
    public void crearPanel(){
        JPanel panel = new JPanel();
        this.Titulo = new JLabel ("Venta");
        this.Titulo.setFont(font2);
        panel.setLayout(new BorderLayout());
        panel.add(this.Titulo, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(10, 2, 5, 5));
        
        JLabel wite = new JLabel("  ");
        
        this.fecha = new JLabel("Fecha: ");
        this.cFecha = new JTextField(); this.cFecha.setText("dd-mm-aaaa");
        subPanel.add(this.fecha); subPanel.add(this.cFecha);
                
        this.codVenta = new JLabel("Codigo de venta: ");
        this.cCodVenta = new JTextField(); this.cCodVenta.setText("xxxxxxxx");
        subPanel.add(this.codVenta); subPanel.add(this.cCodVenta);
        
        this.empleado = new JLabel("Empleado");
        this.idEmpleado = new JLabel("Identificación: ");
        this.nombre = new JLabel("Nombre: ");
        this.cliente = new JLabel("Cliente");
        this.idCliente = new JLabel("Identificacion");
        this.nombreCliente = new JLabel("Nombre: ");
        this.email = new JLabel("Email: ");
        
        this.contenedor.add(panel, BorderLayout.CENTER);
    }
}
