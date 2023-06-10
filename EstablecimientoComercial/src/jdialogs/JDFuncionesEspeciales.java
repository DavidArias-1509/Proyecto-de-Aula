package jdialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class JDFuncionesEspeciales extends JDialog implements MouseListener{
    private Container contenedor;
    
    private JLabel Titulo; 
        
    private JPanel option1, option2,option3, option4,option5, option6, option7;
    private JLabel opt1, opt2,opt3, opt4,opt5, opt6,opt7; 

    public JDFuncionesEspeciales(Frame owner, String title, boolean modal) {
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
        this.funcionalidad();//Para iniciar los eventos
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
        
        JLabel t3 = new JLabel("Funciones Especiales");
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
        this.Titulo = new JLabel ("Opciones de Balance");
        this.Titulo.setFont(font2);
        sPanel.add(this.Titulo);
        this.Titulo.setForeground(Color.black);
        panel.setLayout(new BorderLayout());
        panel.add(sPanel, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.WHITE);
        subPanel.setLayout(new GridLayout(7, 1, 10,5));
        
        this.option1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); this.option1.setBackground(Color.WHITE);
        this.opt1= new JLabel("Ver Detalle Venta"); this.opt1.setFont(font2);
        this.opt1.setForeground(Color.BLACK); this.opt1.setVerticalAlignment(SwingConstants.CENTER);
        this.option1.add(this.opt1);
        
        this.option2 = new JPanel(new FlowLayout(FlowLayout.LEFT)); this.option2.setBackground(Color.WHITE);
        this.opt2 = new JLabel("Ver detalle Compra"); this.opt2.setFont(font2);
        this.opt2.setForeground(Color.black); this.opt2.setVerticalAlignment(SwingConstants.CENTER);
        this.option2.add(this.opt2);
        
        this.option3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); this.option3.setBackground(Color.WHITE);
        this.opt3= new JLabel("Modificar Inventario"); this.opt3.setFont(font2);
        this.opt3.setForeground(Color.BLACK); this.opt3.setVerticalAlignment(SwingConstants.CENTER);
        this.option3.add(this.opt3);
        
        this.option4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); this.option4.setBackground(Color.WHITE);
        this.opt4 = new JLabel("Eliminar Venta"); this.opt4.setFont(font2);
        this.opt4.setForeground(Color.black); this.opt4.setVerticalAlignment(SwingConstants.CENTER);
        this.option4.add(this.opt4);
        
        this.option5 = new JPanel(new FlowLayout(FlowLayout.LEFT)); this.option5.setBackground(Color.WHITE);
        this.opt5= new JLabel("EliminarCompra"); this.opt5.setFont(font2);
        this.opt5.setForeground(Color.BLACK); this.opt5.setVerticalAlignment(SwingConstants.CENTER);
        this.option5.add(this.opt5);
        
        this.option6 = new JPanel(new FlowLayout(FlowLayout.LEFT)); this.option6.setBackground(Color.WHITE);
        this.opt6 = new JLabel("Ver Listado de Empleados"); this.opt6.setFont(font2);
        this.opt6.setForeground(Color.black); this.opt6.setVerticalAlignment(SwingConstants.CENTER);
        this.option6.add(this.opt6);
        
        this.option7 = new JPanel(new FlowLayout(FlowLayout.LEFT)); this.option7.setBackground(Color.WHITE);
        this.opt7 = new JLabel("Registrar Empleado"); this.opt7.setFont(font2);
        this.opt7.setForeground(Color.black); this.opt7.setVerticalAlignment(SwingConstants.CENTER);
        this.option7.add(this.opt7);
        
        subPanel.add(this.option1);
        subPanel.add(this.option2);
        subPanel.add(this.option3);
        subPanel.add(this.option4);
        subPanel.add(this.option5);
        subPanel.add(this.option6);
        subPanel.add(this.option7);
        
        JPanel soutPanel = new JPanel(); soutPanel.setBackground(Color.white);
        
        panel.add(sPanel, BorderLayout.NORTH);
        panel.add(subPanel, BorderLayout.CENTER);
        panel.add(soutPanel, BorderLayout.SOUTH);
        
        this.contenedor.add(panel, BorderLayout.CENTER);
    }

public void funcionalidad(){
        option1.addMouseListener(this);
        option2.addMouseListener(this);
        option3.addMouseListener(this);
        option4.addMouseListener(this);
        option5.addMouseListener(this);
        option6.addMouseListener(this);
        option7.addMouseListener(this);
     }    
    
@Override
    public void mouseClicked(MouseEvent c) {
        if(c.getSource() == this.option1){
               JOptionPane.showMessageDialog(null, "Detalle Venta");
            
        }else if(c.getSource() == this.option2){
                JOptionPane.showMessageDialog(null, "Detalle Compra");
        
        }else if(c.getSource() == this.option3){
               JOptionPane.showMessageDialog(null, "Modificar Inventario");
        
        }else if(c.getSource() == this.option4){
                JOptionPane.showMessageDialog(null, "Eliminar Venta");
        
        }else if(c.getSource() == this.option5){
               JOptionPane.showMessageDialog(null, "Eliminar Compra");
        
        }else if(c.getSource() == this.option6){
                JOptionPane.showMessageDialog(null, "Lista Empleados");
            
        }else if(c.getSource() == this.option7){
                JOptionPane.showMessageDialog(null, "Registrar Empleado");
            }
    }

    @Override
    public void mousePressed(MouseEvent c) {
        
    }

    @Override
    public void mouseReleased(MouseEvent c) {
        
    }

    @Override
    public void mouseEntered(MouseEvent c) {
            if(c.getSource() == this.option1){
               this.option1.setBackground(c1);
               this.opt1.setFont(font1);
               this.opt1.setForeground(Color.white);
            
            }else if(c.getSource() == this.option2){
                this.option2.setBackground(c1);
               this.opt2.setFont(font1);
               this.opt2.setForeground(Color.white);
            
            }else if(c.getSource() == this.option3){
               this.option3.setBackground(c1);
               this.opt3.setFont(font1);
               this.opt3.setForeground(Color.white);
            
            }else if(c.getSource() == this.option4){
                this.option4.setBackground(c1);
               this.opt4.setFont(font1);
               this.opt4.setForeground(Color.white);
            
            }else if(c.getSource() == this.option5){
               this.option5.setBackground(c1);
               this.opt5.setFont(font1);
               this.opt5.setForeground(Color.white);
            
            }else if(c.getSource() == this.option6){
                this.option6.setBackground(c1);
               this.opt6.setFont(font1);
               this.opt6.setForeground(Color.white);
            }
            else if(c.getSource() == this.option7){
                this.option7.setBackground(c1);
               this.opt7.setFont(font1);
               this.opt7.setForeground(Color.white);
            }
    }

    @Override
    public void mouseExited(MouseEvent c) {
        if(c.getSource() == this.option1){
                this.option1.setBackground(Color.WHITE);
                this.opt1.setFont(font2);
                this.opt1.setForeground(Color.BLACK);
            
        }else if(c.getSource() == this.option2){
                this.option2.setBackground(Color.WHITE);
                this.opt2.setFont(font2);
                this.opt2.setForeground(Color.BLACK);
            
        }else if(c.getSource() == this.option3){
                this.option3.setBackground(Color.WHITE);
                this.opt3.setFont(font2);
                this.opt3.setForeground(Color.BLACK);
            
        }else if(c.getSource() == this.option4){
                this.option4.setBackground(Color.WHITE);
                this.opt4.setFont(font2);
                this.opt4.setForeground(Color.BLACK);
            
        } else if(c.getSource() == this.option5){
                this.option5.setBackground(Color.WHITE);
                this.opt5.setFont(font2);
                this.opt5.setForeground(Color.BLACK);
            
        }else if(c.getSource() == this.option6){
                this.option6.setBackground(Color.WHITE);
                this.opt6.setFont(font2);
                this.opt6.setForeground(Color.BLACK);
            
        }else if(c.getSource() == this.option7){
                this.option7.setBackground(Color.WHITE);
                this.opt7.setFont(font2);
                this.opt7.setForeground(Color.BLACK);
            }
    }
}
