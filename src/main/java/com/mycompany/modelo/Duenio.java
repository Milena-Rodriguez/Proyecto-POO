/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import com.mycompany.proyectopoojar.App;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.control.Alert;

/**
 *
 * @author PC
 */
public class Duenio extends Persona{
    private String cedula;
    private String apellido;
    

    //Constructor
    public Duenio(String ced, String n, String a, String d, String t, Ciudad c, String e){
        super(n,d,t,c,e);//super para constructor de clase padre (Persona)
        this.cedula=ced;
        this.apellido=a;
    }
    
     //se sobreescriben los getters de la clase padre(Persona)
    public String getCedula(){return this.cedula;}
    @Override
    public String getNombre(){return super.getNombre();}
    public String getApellido(){return this.apellido;}
    @Override
    public String getDireccion(){return super.getDireccion();}
    @Override
    public String getTelefono(){return super.getTelefono();}
    @Override
    public Ciudad getCiudad(){return super.getCiudad();}
    @Override
    public String getEmail(){return super.getEmail();}
    

    //se sobreescriben los setters de la clase padre(Persona)
    //los setters son para poder cambiar la informacion de duenio,
    //por lo que no se integra un setCedula() ya que el id es permanente
    @Override
    public void setNombre(String nn){super.setNombre(nn);}
    
    public void setApellido(String a){this.apellido = a;}
    
    @Override
    public void setDireccion(String dd){super.setDireccion(dd);}
    @Override
    public void setTelefono(String t){super.setTelefono(t);}
    @Override
    public void setCiudad(Ciudad c){super.setCiudad(c);}
    @Override
    public void setEmail(String e){super.setEmail(e);}
    
    @Override
    public String toString(){
        return "Cedula del duenio: " + this.cedula + ", Apellido del duenio: " +this.apellido 
                + ", "+super.toString();}//se sobreescribe el metodo toString de la clase padre//se sobreescribe el metodo toString de la clase padre
    
    public int compareTo(Duenio o) {
        return super.compareTo(o); //To change body of generated methods, choose Tools | Templates.
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Duenio other = (Duenio) obj;
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }
    
    public static ArrayList<Duenio> cargarDuenios(String ruta) {
        ArrayList<Duenio> duenios = new ArrayList<>();
        try(InputStream input = Duenio.class.getClassLoader().getResourceAsStream(ruta);
            BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String linea;
            br.readLine();//se lee la primera liena de encabezado
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {   String[] info = linea.split(",");//separar los datos por coma
                String c =  info[5];
                Ciudad ciu = new Ciudad (c);
                //crear objeto y agregar a la lista
                duenios.add(new Duenio(info[0],info[1],info[2],info[3],info[4],ciu,info[6]));
       }}  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
       return duenios;
    }}
