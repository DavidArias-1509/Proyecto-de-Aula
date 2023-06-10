/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import cuentas.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import preparaciones.Receta;

/**
 *
 * @author karla
 */
public class ListaPlato implements Logica {
    
    private List<Receta> plato;

    public ListaPlato() {
        this.plato = new ArrayList();
    }
    
    @Override
    public Receta buscarItem(String id) {
        for (Receta p : this.plato){
            if(p.getNombre().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void borrarItem(String id) throws IOException {
        for(Receta p : this.plato){
            if(p.getNombre().equals(id)){
                this.plato.remove(p);
            }
        }
    }

    /**
     *
     * @param item
     * @throws IOException
     */
    @Override
    public void agregarItem(Object item) throws IOException {
        Receta p = (Receta) item;
        for (Receta p1 :this.plato){
            if(p.getNombre().equals(p1.getNombre())){
                throw new IOException("Plato ya existe en menu");
            }
        }
        this.plato.add(p);
        
    }

    @Override
    public List<Receta> generarInforme() throws IOException {
        return this.plato;
    }
    
}
