/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author karla
 */
public abstract class Archivo implements Logica, Serializable{
    protected File arch;
    protected ObjectOutputStream aEscritura;
    protected ObjectInputStream aLectura;

    public Archivo(String name) {
        this.arch = new File(DIREC + name);
    }
    
}
