package jdialogs;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDInventario extends JDialog {
    private JLabel Titulo;
    private Container contenedor;  

    public JDInventario(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.initComponents();
    }
    
    public void initComponents(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.crearPanel();
        this.setSize(400,400);
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void crearPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 5, 5));
        this.Titulo = new JLabel("Inventario");
        panel.add(Titulo);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.NORTH);
    }
}
