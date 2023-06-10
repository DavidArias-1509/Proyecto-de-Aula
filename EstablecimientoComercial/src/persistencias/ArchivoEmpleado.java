/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import empleados.Empleado;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author karla
 */
public class ArchivoEmpleado extends Archivo implements Logica {
    
    private ListEmpleados list;
    
    public ArchivoEmpleado() {
        this("Empleados.obj");
    }

    public ArchivoEmpleado(String name) {
        super(name);
    }
    
    public void leerListaEmpleados() throws IOException{
        if(!this.arch.exists()){
            this.list = new ListEmpleados();
        }else{
            this.aLectura=null;
            try{
               this.aLectura = new ObjectInputStream(new FileInputStream(this.arch));
               this.list = (ListEmpleados) this.aLectura.readObject();
            }catch(IOException ex){
                throw new IOException("Archivo no entocntrado");
            } catch (ClassNotFoundException ex) {
                throw new IOException("No se encontro elementos");
            }finally{
                if(this.aLectura!=null){
                    this.aLectura.close();
                }
            }
        }
    }

    @Override
    public Object buscarItem(String id) {
        try {
            this.leerListaEmpleados();
            return this.list.buscarItem(id);
        } catch (IOException ex) {
            System.err.println("Erro: "+ ex);
        }
        return null;
    }
    
    public void guardarLista() throws IOException{
        this.aEscritura = null;
        try{
            this.aEscritura = new ObjectOutputStream(new FileOutputStream(this.arch));
            this.aEscritura.writeObject(this.list);
        }catch(IOException ex){
            System.err.println("Error: "+ ex );
        }finally{
            if(this.aEscritura!=null){
                this.aEscritura.close();
            }
        }
    }

    @Override
    public void borrarItem(String id) throws IOException {
        this.leerListaEmpleados();
        this.list.borrarItem(id);
        this.guardarLista();
    }

    @Override
    public void agregarItem(Object item) throws IOException {
        this.leerListaEmpleados();
        this.list.agregarItem(item);
        this.guardarLista();
    }

    @Override
    public List generarInforme() throws IOException {
        this.leerListaEmpleados();
        return this.list.generarInforme();
    }
    
}
