package vista.paneles;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelInventario extends JDialog {
    private Panel panel; 
    private Container contenedor;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private String[] titles = {"Codigo", "Producto", "Cantidad"};
    int j = 3;
    private String[][] datos = new String[j][6];
    
    public PanelInventario(){
        setVisible(true);
        this.initComponents();
    }

    public void initComponents() {
        this.panel = new Panel();
        this.panel.add(contenedor);
        contenedor = this.getContentPane();
        this.setLayout(new BorderLayout()); 
        crearFormato();
    }
    
    public void crearFormato(){
        
    }
    
    public void crearPanelTabla(){
        
        JPanel panel = new JPanel();
        this.tabla = new JTable();
        
        this.tabla.setModel(this.modeloTabla);
        this.tabla.setPreferredSize(new Dimension(950, 400));
        JScrollPane sPanel = new JScrollPane(this.tabla);
        sPanel.setPreferredSize(new Dimension(950, 400));
        panel.add(sPanel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.CENTER);
    
    }

    

    
}
