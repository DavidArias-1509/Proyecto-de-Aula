/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import empleados.Empleado;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karla
 */
public class ListEmpleados implements Logica {
    
    private List<Empleado> list;

    public ListEmpleados() {
        this.list = new ArrayList();
    }
    
    @Override
    public Object buscarItem(String id) {
        for (Empleado e : this.list){
            if(String.valueOf(e.getIdentificacion()).equals(id)){
                return e;
            }
        }
        return null;
    }

    @Override
    public void borrarItem(String id) throws IOException {
        for(Empleado e : this.list){
            if(String.valueOf(e.getIdentificacion()).equals(id)){
                this.list.remove(e);
            }
        }
    }

    @Override
    public void agregarItem(Object item) throws IOException {
        char encontro = 'n';
        Empleado e = (Empleado) item;
        for (Empleado e1 :this.list){
            if (e.getIdentificacion() == e1.getIdentificacion()){
                throw new IOException("Identificacion se encuentra en sistema");
            }
        }
        this.list.add(e);
    }

    @Override
    public List<Empleado> generarInforme() throws IOException {
        return this.list;
    }
    
}
