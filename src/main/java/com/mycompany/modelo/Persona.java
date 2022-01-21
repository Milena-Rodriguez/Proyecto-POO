/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

/**
 *
 * @author PC
 */
public abstract class Persona {
    private String nombre;
    private String direccion;
    private String telefono;
    private Ciudad ciudad;
    private String email;
    
    public Persona(String n, String d, String t, Ciudad c, String e){
        this.nombre=n;
        this.direccion=d;
        this.telefono=t;
        this.ciudad=c;
        this.email=e;
    }
    
    //getters
    public String getNombre(){
        return this.nombre;
    }
    public String getDireccion(){
        return this.direccion;
    }    
    public String getTelefono(){
        return this.telefono;
    }
    public Ciudad getCiudad(){
        return this.ciudad;
    }
    public String getEmail(){
        return this.email;
    }
    
    //setters
    public void setNombre(String no){
        this.nombre = no;
    }
    public void setDireccion(String di){
        this.direccion = di;
    }    
    public void setTelefono(String tel){
        this.telefono = tel;
    }
    public void setCiudad(Ciudad ciu){
        this.ciudad = ciu;
    }
    public void setEmail(String em){
        this.email = em;
    }
    
    public int compareTo(Persona o) {
        
        return nombre.compareToIgnoreCase(o.nombre);
    }
    @Override
    public String toString(){
    return this.nombre + "," + this.direccion + "," + this.telefono
            + "," + this.ciudad.toString() + "," + this.email;}
    
}

