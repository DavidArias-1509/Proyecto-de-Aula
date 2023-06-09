/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import cuentas.Producto;

/**
 *
 * @author karla
 */
public class ArchivoInventario implements Logica{
    private File arch;
    private ObjectOutputStream aEscritura;
    private ObjectInputStream aLectura;
    private List<Producto> list;
    
    public ArchivoInventario(String name){
        this.arch = new File(DIREC + name);
    }
    
    public void leerInventario() throws IOException{
        if(!this.arch.exists()){
            this.list = new ArrayList();
        }else{
            this.aLectura=null;
            try{
               this.aLectura = new ObjectInputStream(new FileInputStream(this.arch));
               this.list = (List<Producto>) this.aLectura.readObject();
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
    public Producto buscarItem(String id) {
        try {
            this.leerInventario();
            for (Producto p : this.list){
                if(p.getNombre().equals(id)){
                    return p;
                }
            }
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
        this.leerInventario();
        for(Producto p : this.list){
            if(p.getNombre().equals(id)){
                this.list.remove(p);
            }
        }
        this.guardarLista();
    }
    
    @Override
    public void guardarItem(Object item) throws IOException {
        this.leerInventario();
        this.list.add((Producto) item);
        this.guardarLista();
    }

    @Override
    public List<Producto> generarInforme() throws IOException {
        this.leerInventario();
        return this.list;
    }
}
