/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.cuentas;

/**
 *
 * @author david
 */
public class Cliente {
    private String nombre;
    private String e_mail;
    private long id;

    public Cliente(String nombre, String e_mail, long id) {
        this.nombre = nombre;
        this.e_mail = e_mail;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getE_mail() {
        return e_mail;
    }

    public long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nIdentificacion"+id+"\nE-mail: "+e_mail;
    }
}
