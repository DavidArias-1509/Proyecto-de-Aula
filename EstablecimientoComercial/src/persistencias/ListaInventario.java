/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package persistencias;

import java.util.*;
import cuentas.Producto;
import java.io.IOException;

import java.util.*;
import preparaciones.Ingrediente;

/**
 *+
 * @author karla
 */
public class ListaInventario implements Logica{
    private Map<String ,Producto> Item;
    private List<Producto> list;

    public ListaInventario() {
        this.Item = new HashMap();
        this.list = new ArrayList();
    }
    
    
//    public void agregarItem(Producto p){
//        char Encontro = 'n';
//        int adicion;
//        Iterator<String> i = this.Item.keySet().iterator();
//        if((this.Item!= null)){
//            while(i.hasNext()){
//                String key = i.next();
//                if (this.Item.get(key).equals(p.getNombre())){
//                    Encontro = 's';
//                    adicion = this.Item.get(key).getCnatidadDisponible() + p.getCnatidadDisponible();
//                    this.Item.get(key).setCnatidadDisponible(adicion);
//                    this.Item.get(key).setPrecio(p.getPrecio());
//                }
//            }
//        }
//        
//        if(Encontro == 'n'){
//            this.Item.put(p.getNombre(), p);
//        }
//    }
//    
//    public void reducirItem(Ingrediente i){
//        char Encontro = 'n';
//        int reduccion;
//        Iterator<String> b = this.Item.keySet().iterator();
//        while(b.hasNext()){
//            String key = b.next();
//            if (i.getNombre().equals(this.Item.get(key))){
//                Encontro = 's';
//                reduccion = this.Item.get(key).getCnatidadDisponible() - i.getCantidad();
//                this.Item.get(key).setCnatidadDisponible(reduccion);
//            } else {
//            }
//        }
//        if(Encontro == 'n'){
//            System.out.println("No se encontro Item");
//        }
//    }

//    public Map<String ,Producto> getItem() {
//        return Item;
//    }

    @Override
    public Producto buscarItem(String id) {
        for (Producto p : this.list){
            if(p.getNombre().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void borrarItem(String id) throws IOException {
        for(Producto p : this.list){
            if(p.getNombre().equals(id)){
                this.list.remove(p);
            }
        }
    }

    @Override
    public void guardarItem(Object item) throws IOException {
        this.list.add((Producto) item);
    }

    @Override
    public List<Producto> generarInforme() throws IOException {
        return this.list;
    }

    
}
