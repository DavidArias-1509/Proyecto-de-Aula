package jdialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JDRegistroCompra extends JDialog implements MouseListener{
        private Container contenedor; 
        private JLabel Titulo; 
        
        private JPanel option1, option2;
        private JLabel opt1, opt2; 
        
    public JDRegistroCompra(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
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
        
        JLabel t3 = new JLabel("Registro de Compras");
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
        this.Titulo = new JLabel ("Venta");
        this.Titulo.setFont(font2);
        sPanel.add(this.Titulo);
        this.Titulo.setForeground(Color.black);
        panel.setLayout(new BorderLayout());
        panel.add(sPanel, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.WHITE);
        subPanel.setLayout(new GridLayout(2, 1, 10,5));
        
        this.option1 = new JPanel(); this.option1.setBackground(Color.WHITE);
        this.opt1= new JLabel("Compra de Ingredientes"); this.opt1.setFont(font2);
        this.opt1.setForeground(Color.BLACK); this.opt1.setVerticalAlignment(SwingConstants.CENTER);
        this.option1.add(this.opt1);
        
        this.option2 = new JPanel(); this.option2.setBackground(Color.WHITE);
        this.opt2 = new JLabel("Otras compras"); this.opt2.setFont(font2);
        this.opt2.setForeground(Color.black); this.opt2.setVerticalAlignment(SwingConstants.CENTER);
        this.option2.add(this.opt2);
        
        subPanel.add(this.option1);
        subPanel.add(this.option2);
        
        JPanel soutPanel = new JPanel(); soutPanel.setBackground(Color.white);
        
        panel.add(sPanel, BorderLayout.NORTH);
        panel.add(subPanel, BorderLayout.CENTER);
        panel.add(soutPanel, BorderLayout.SOUTH);
        
        this.contenedor.add(panel, BorderLayout.CENTER);
    }
    
    public void funcionalidad(){
        this.option1.addMouseListener(this);
        this.option2.addMouseListener(this);
     }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.option1){
               JOptionPane.showMessageDialog(null, "Compra de ingredientes");
            }else if(e.getSource() == this.option2){
                JOptionPane.showMessageDialog(null, "Otras compras");
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
            if(e.getSource() == this.option1){
               this.option1.setBackground(c1);
               this.opt1.setFont(font1);
               this.opt1.setForeground(Color.white);
            }else if(e.getSource() == this.option2){
                this.option2.setBackground(c1);
               this.opt2.setFont(font1);
               this.opt2.setForeground(Color.white);
            }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.option1){
                this.option1.setBackground(Color.WHITE);
                this.opt1.setFont(font2);
                this.opt1.setForeground(Color.BLACK);
            }else if(e.getSource() == this.option2){
                this.option2.setBackground(Color.WHITE);
                this.opt2.setFont(font2);
                this.opt2.setForeground(Color.BLACK);
            }
    }
}
