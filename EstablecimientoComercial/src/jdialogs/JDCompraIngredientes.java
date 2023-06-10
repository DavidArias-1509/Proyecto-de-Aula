package jdialogs;

import cuentas.Compra;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JDCompraIngredientes extends JDialog implements MouseListener{
    private JLabel Titulo;
    private Container contenedor;  
    private JButton adicion, guardar, cancelar; 
    private Compra compra;
    private DateTimeFormatter formato;
    
    private JLabel fecha, lbCodCompra, empleado, lbIngrediente, lbCantidad, cliente, txtPrecioUnidad, nombreCliente, email, total, precio;
    private JFormattedTextField cFecha, cCodCompra, cIngrediente, cCantidad, cPrecioUnidad, cNombreCliente, cEmail;

    public JDCompraIngredientes(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.initComponents();
    }
    
     public void initComponents(){
        this.setResizable(false);
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.crear();
        this.setSize(1000,1000);
        this.setPreferredSize(new Dimension(900, 650));
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
        panel.setBackground(c1);
        JPanel sPanel = new JPanel();
        sPanel.setBackground(Color.WHITE);
        this.Titulo = new JLabel ("Compra Ingrediente");
        this.Titulo.setFont(font2);
        sPanel.add(this.Titulo);
        panel.setLayout(new BorderLayout());
        panel.add(sPanel, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.WHITE);
        subPanel.setLayout(new GridLayout(12, 4, 5, 5));
        
        
        this.fecha = new JLabel("Fecha: ");
        this.cFecha = new JFormattedTextField(); 
        this.cFecha.setText("dd-mm-aaaa");
        subPanel.add(this.fecha); subPanel.add(this.cFecha);
                
        this.lbCodCompra = new JLabel("Codigo de Compra: ");
        this.cCodCompra = new JFormattedTextField(); this.cCodCompra.setText("xxxxxxxx");
        subPanel.add(this.lbCodCompra); 
        subPanel.add(this.cCodCompra);
        
//        this.empleado = new JLabel("Empleado");
//        subPanel.add(this.empleado); 
//        subPanel.add(new JLabel("          "));
        
        this.lbIngrediente = new JLabel("Ingrediente: ");
        this.cIngrediente = new JFormattedTextField();
        this.cIngrediente.setValue("");
        subPanel.add(this.lbIngrediente); 
        subPanel.add(this.cIngrediente);
        
        this.lbCantidad = new JLabel("Cantidad: ");
        this.cCantidad = new JFormattedTextField();
        this.cCantidad.setText("");
        subPanel.add(this.lbCantidad); 
        subPanel.add(this.cCantidad);
        
//        this.cliente = new JLabel("Precio por unidad");
//        subPanel.add(this.cliente); 
//        subPanel.add(new JLabel("      "));
        
        this.txtPrecioUnidad = new JLabel("Precio por unidad");
        this.cPrecioUnidad = new JFormattedTextField();
        this.cPrecioUnidad.setText("");
        subPanel.add(this.txtPrecioUnidad); 
        subPanel.add(this.cPrecioUnidad);
        
//        this.nombreCliente = new JLabel("Nombre: ");
//        this.cNombreCliente = new JFormattedTextField();
//        this.cNombreCliente.setText(" ");
//        subPanel.add(this.nombreCliente); 
//        subPanel.add(this.cNombreCliente);
//        
//        this.email = new JLabel("Email: ");
//        this.cEmail = new JFormattedTextField(); this.cEmail.setText("Example@mail.com");
//        subPanel.add(this.email); 
//        subPanel.add(this.cEmail);
        
                
        subPanel.add(new JLabel("Platos"));
        subPanel.add(new JLabel());
        
        this.adicion = new JButton(); 
        this.adicion.setText("+ Añadir Plato");
        this.adicion.setForeground(Color.WHITE);
        this.adicion.setBackground(c1);
        this.adicion.addMouseListener(this);
        subPanel.add(this.adicion); subPanel.add(new JLabel());
        
        this.total = new JLabel("Valor total");
        this.precio = new JLabel("");
        this.precio.setBorder(BorderFactory.createLineBorder(c1, 2));
        subPanel.add(this.total); subPanel.add(this.precio);
        
        panel.add(subPanel, BorderLayout.CENTER);
        
        JPanel panels = new JPanel();
        panels.setBackground(Color.white);
        panels.setLayout(new GridLayout(1 , 1,0, 20));
        this.guardar = new JButton();
        this.cancelar = new JButton();
        this.guardar.setText("Guardar");
        this.guardar.addMouseListener(this);
        this.guardar.setBackground(c1);
        this.guardar.setForeground(Color.white);
        this.cancelar.setText("Cancelar");
        this.cancelar.setBackground(c1);
        this.cancelar.setForeground(Color.white);
        
        panels.add(this.guardar);
        panels.add(this.cancelar);
        
        panel.add(panels, BorderLayout.SOUTH);
        
        this.contenedor.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        LocalDate date;
        date = LocalDate.parse(this.cFecha.getText(),this.formato);
        if(e.getSource() == this.adicion){
            try {
                if(this.compra==null){
                    this.compra = new Compra(date);
                }
                String ingre= this.cIngrediente.getText();
                int canti= Integer.parseInt(this.cCantidad.getText());
                double precio = Double.parseDouble(this.cPrecioUnidad.getText());
                this.compra.agregaACarrito(ingre, canti, precio, "");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error", HEIGHT);
            }
        }else if(e.getSource() == this.guardar){
            try {
                if(this.compra==null){
                    this.compra = new Compra(date);
                }
                String ingre= this.cIngrediente.getText();
                int canti= Integer.parseInt(this.cCantidad.getText());
                double precio = Double.parseDouble(this.cPrecioUnidad.getText());
                this.compra.agregaACarrito(ingre, canti, precio, "");
                this.compra.realizarCompra();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error", HEIGHT);
            }
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
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}