/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<<< HEAD:EstablecimientoComercial/src/persistencias/Inventario.java
package persistencias;

import java.util.*;
import modelos.cuentas.Producto;
import modelos.preparaciones.Ingrediente;
========
package cuentas;

import java.util.*;
import preparaciones.Ingrediente;
>>>>>>>> 4f37e06b8bf7de3963dc8f7113a728c11e83cc21:EstablecimientoComercial/src/cuentas/Inventario.java

/**
 *+
 * @author karla
 */
public class Inventario {
    private Map<String ,Producto> Item;
    private List<Producto> list;

    public Inventario() {
        this.Item = new HashMap();
        this.list = new ArrayList();
    }
    
    
    public void agregarItem(Producto p){
        char Encontro = 'n';
        int adicion;
        Iterator<String> i = this.Item.keySet().iterator();
        if((this.Item!= null)){
            while(i.hasNext()){
                String key = i.next();
                if (this.Item.get(key).equals(p.getNombre())){
                    Encontro = 's';
                    adicion = this.Item.get(key).getCnatidadDisponible() + p.getCnatidadDisponible();
                    this.Item.get(key).setCnatidadDisponible(adicion);
                    this.Item.get(key).setPrecio(p.getPrecio());
                }
            }
        }
        
        if(Encontro == 'n'){
            this.Item.put(p.getNombre(), p);
        }
    }
    
    public void reducirItem(Ingrediente i){
        char Encontro = 'n';
        int reduccion;
        Iterator<String> b = this.Item.keySet().iterator();
        while(b.hasNext()){
            String key = b.next();
            if (i.getNombre().equals(this.Item.get(key))){
                Encontro = 's';
                reduccion = this.Item.get(key).getCnatidadDisponible() - i.getCantidad();
                this.Item.get(key).setCnatidadDisponible(reduccion);
            } else {
            }
        }
        if(Encontro == 'n'){
            System.out.println("No se encontro Item");
        }
    }

    public Map<String ,Producto> getItem() {
        return Item;
    }

    
}
