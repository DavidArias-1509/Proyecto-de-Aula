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
    private ListaInventario list;
    
    public ArchivoInventario(String name){
        this.arch = new File(DIREC + name);
    }
    
    public void leerInventario() throws IOException{
        if(!this.arch.exists()){
            this.list = new ListaInventario();
        }else{
            this.aLectura=null;
            try{
               this.aLectura = new ObjectInputStream(new FileInputStream(this.arch));
               this.list = (ListaInventario) this.aLectura.readObject();
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
    
    public void sacarItem (List<Producto> receta) throws IOException{
        this.leerInventario();
        this.list.sacarItem(receta);
        this.guardarLista();
    }

    @Override
    public Producto buscarItem(String id) {
        try {
            this.leerInventario();
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
        this.leerInventario();
        this.list.borrarItem(id);
        this.guardarLista();
    }
    
    @Override
    public void agregarItem(Object item) throws IOException {
        this.leerInventario();
        this.list.agregarItem(item);
        this.guardarLista();
    }

    @Override
    public List<Producto> generarInforme() throws IOException {
        this.leerInventario();
        return this.list.generarInforme();
    }
}
