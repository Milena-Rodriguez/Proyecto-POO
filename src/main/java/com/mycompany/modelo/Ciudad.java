/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class Ciudad {
    private String nombre;
    private String provincia;
    
    //Constructor
    public Ciudad(String n, String p){
        this.nombre=n;
        this.provincia=p;
    }
    public Ciudad(String n){
        this.nombre=n;
    }
    //GETTERS
    public String getNombre(){return this.nombre;}
    public String getProvincia(){return this.provincia;}
    
    
    //Se genera un código
    public String generarCodigo(){
        //- se toma los tres primeros caracteres de los atributos de tipo String
        char ch1 = getNombre().charAt(0);
        char ch2 = getProvincia().charAt(0);
        char ch3 = getNombre().charAt(1);
        char ch4 = getProvincia().charAt(1);
        char ch5 = getNombre().charAt(2);
        char ch6 = getProvincia().charAt(2);
        String cod = String.valueOf(ch1+ch2+ch3+ch4+ch5+ch6);
        return cod;//se devuelve un string de 6 caracteres
    }
    @Override
    public String toString(){
        return this.nombre ;}
    
    public static ArrayList<Ciudad> cargarCuiudades(String ruta) {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        
       
        try(InputStream input = Ciudad.class.getClassLoader().getResourceAsStream(ruta);
                BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
                String linea = null;
            
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(",");//separar los datos por coma
                //crear objeto y agregar a la lista
                ciudades.add(new Ciudad(info[1],info[2]));
                        
            }
        }  catch (IOException ex) {
            ex.printStackTrace();}
       return ciudades;
    }
}
