/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import preparaciones.Receta;

/**
 *
 * @author karla
 */
public class ArchivoPlato extends Archivo {
    
    private ListaPlato list;
    
    public ArchivoPlato() {
        this("Plato.obj");
    }
    
    public ArchivoPlato(String name) {
        super(name);
    }
    
    public void leerListaPlato() throws IOException{
        if(!this.arch.exists()){
            this.list = new ListaPlato();
        }else{
            this.aLectura=null;
            try{
               this.aLectura = new ObjectInputStream(new FileInputStream(this.arch));
               this.list = (ListaPlato) this.aLectura.readObject();
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
    public Receta buscarItem(String id) {
        try {
            this.leerListaPlato();
            return this.list.buscarItem(id);
        } catch (IOException ex) {
            System.err.println("Erro: "+ ex);
        }
        return null;
    }

    @Override
    public void borrarItem(String id) throws IOException {
        this.leerListaPlato();
        this.list.borrarItem(id);
        this.guardarLista();
    }

    @Override
    public void agregarItem(Object item) throws IOException {
        this.leerListaPlato();
        this.list.agregarItem(item);
        this.guardarLista();
    }

    @Override
    public List<Receta> generarInforme() throws IOException {
       this.leerListaPlato();
       return this.list.generarInforme();
    }
    
}
