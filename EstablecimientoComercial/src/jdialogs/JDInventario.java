package jdialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class JDInventario extends JDialog {
    private JLabel Titulo;
    private Container contenedor;  
    private JTable tabla;
    private String[][] datos = new String[5][6];
    private String[] titulo = {"Producto", "Cantidad Disponible"};
    private DefaultTableModel modeloTabla ;

    public JDInventario(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.initComponents();
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
        
        JLabel t3 = new JLabel("Inventario");
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
        this.Titulo = new JLabel ("Productos");
        this.Titulo.setFont(font2);
        panel.setLayout(new BorderLayout());
        panel.add(this.Titulo, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.CENTER);
        
        this.tabla = new JTable();
        this.modeloTabla = new DefaultTableModel(this.datos, this.titulo);
        this.tabla.setModel(this.modeloTabla);
        this.tabla.setPreferredSize(new Dimension(950, 400));
        JScrollPane sPanel = new JScrollPane(this.tabla);
        sPanel.setPreferredSize(new Dimension(950, 400));
        panel.add(sPanel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.CENTER);
    }
}
