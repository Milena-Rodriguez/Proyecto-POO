/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.util.ArrayList;

/**
 *
 * @author PC
 */

public class Auspiciante extends Persona{
    private String webPage;
    
    public Auspiciante(String n, String d, String t, Ciudad c, String e, String web){
        super(n,d,t,c,e);
        this.webPage=web;
    }
    
    //getters
    //se sobreescriben de la clase padre --> Persona
    @Override
    public String getNombre(){return super.getNombre();}
    @Override
    public String getDireccion(){return super.getDireccion();}
    @Override
    public String getTelefono(){return super.getDireccion();}
    @Override
    public Ciudad getCiudad(){return super.getCiudad();}
    @Override
    public String getEmail(){return super.getEmail();}
    public String getWebPage(){return this.webPage;}
    
    
    //metodo para generar codigo
    public String generarCodigo(){
        //- se toma el primer caracter de cada atributo para auspiciante
        char ch1 = getNombre().charAt(0);
        char ch2 = getDireccion().charAt(0);
        char ch3 = getTelefono().charAt(0);
        char ch4 = getCiudad().getNombre().charAt(0);
        char ch5 = getEmail().charAt(0);
        char ch6 = getWebPage().charAt(0);
        String cod = String.valueOf(ch1+ch2+ch3+ch4+ch5+ch6);
        return cod;//se devuelve un string de 6 caracteres
    }
    
    @Override
    public String toString(){
        return  super.toString()+", " + this.webPage ;}//se sobreescribe el metodo toString de la clase padre
    
    public static ArrayList<Auspiciante> cargarAuspiciante(String ruta){
        ArrayList<Auspiciante> auspiciantes = new ArrayList<>();
        
        return auspiciantes;
    }
}

