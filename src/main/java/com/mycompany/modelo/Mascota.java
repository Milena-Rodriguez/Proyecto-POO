/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import com.mycompany.proyectopoojar.App;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Mascota {
    private String nombre;
    private DirigidoA perroOGato;
    private String raza;
    private LocalDate fechaNacimiento;
    private String foto;
    private  Duenio duenio;
    
    //Constructor
    public Mascota(String n, DirigidoA pG, String rz, LocalDate 
            fNac, String f, Duenio due){
        this.nombre=n;
        this.perroOGato=pG;
        this.raza=rz;
        this.fechaNacimiento=fNac;
        this.foto=f;
        this.duenio=due;
    }
    
    //Getters
    public String getNombre(){return this.nombre;}
    public DirigidoA getPerroOGato(){return this.perroOGato;}
    public String getRaza(){return this.raza;}
    public LocalDate getFecha(){return this.fechaNacimiento;}
    public String getFoto(){return this.foto;}
    public Duenio getDuenio(){return this.duenio;}
    
    //setters

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPerroOGato(DirigidoA perroOGato) {this.perroOGato = perroOGato;}
    public void setRaza(String raza) {this.raza = raza;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
    public void setFoto(String foto) {this.foto = foto;}
    public void setDuenio(Duenio duenio) {this.duenio = duenio;}
    
    
    //metodo para generar codigo
    public String generarCodigo(){
        //- se toma los tres primeros caracteres de los atributos de tipo String
        //NOTA: no se escogio caracter de Foto porque se lo va a modificar (Segundo parcial)
        char ch1 = getNombre().charAt(0);
        char ch2 = getNombre().charAt(0);
        char ch3 = getNombre().charAt(0);
        char ch4 = getRaza().charAt(1);
        char ch5 = getRaza().charAt(1);
        char ch6 = getRaza().charAt(1);
        String cod = String.valueOf(ch1+ch2+ch3+ch4+ch5+ch6);
        return cod;//se devuelve un string de 6 caracteres
    }
    
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + ", Perro o Gato: " + this.perroOGato + ", Raza: "
                + this.raza + "Fecha de nacimiento: " + this.fechaNacimiento + ", Foto: " 
                +this.foto + ", Duenio: " + this.duenio.toString();}
    
    public static ArrayList<Mascota> cargarMascotas(String ruta) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        
       
        try(InputStream input = Mascota.class.getClassLoader().getResourceAsStream(ruta);
                BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
                String linea = null;
                br.readLine();
            
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(";");//separar los datos por coma
                DirigidoA tipo;
                if(info[2].equals("perro")){
                    tipo=DirigidoA.PERROS;
                }else{
                    tipo=DirigidoA.GATOS;
            }
                Duenio du;
                for(Duenio d:Duenio.cargarDuenios(App.pathDuenio)){
                    if(info[6].equals(d.getCedula())){
                        du=d;
                    }
                }
                //crear objeto y agregar a la lista
                mascotas.add(new Mascota(info[1],tipo,info[3],LocalDate.parse(info[4]),info[5],du));
                        
            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        
       return mascotas;
    }
}
