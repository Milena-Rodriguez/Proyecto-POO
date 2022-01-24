/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author PC
 */

public class Concurso {
    private String nombre;
    private LocalDate fechaDelEvento;
    private String horaDelEvento;
    private LocalDate fechaInicioDeInscripcion;
    private LocalDate fechaCierreDeInscripcion;
    private Ciudad ciudad;
    private String lugar;
    private String premios;
    private ArrayList<Auspiciante> AusDelConcurso;
    private DirigidoA dirigidoA;
    
    
    //Constructor
    public Concurso(String n, LocalDate fEven, String hEven, LocalDate  fiEven, 
            LocalDate  fcEven, Ciudad c, String l, String pr, ArrayList<Auspiciante> adc, 
            DirigidoA dA  ){
        this.nombre=n;
        this.fechaDelEvento=fEven;
        this.horaDelEvento=hEven;
        this.fechaInicioDeInscripcion=fiEven;
        this.fechaCierreDeInscripcion=fcEven;
        this.ciudad=c;
        this.lugar=l;
        this.premios=pr;
        this.AusDelConcurso=adc;
        this.dirigidoA=dA;
    }

   
    
    //GETTERS
    public String getNombre(){return this.nombre;}
    public LocalDate getFechaDelEvento(){return this.fechaDelEvento;}
    public String getHoraDelEvento(){return this.horaDelEvento;}
    public LocalDate getFechaInicioDeInscripcion(){return this.fechaInicioDeInscripcion;}
    public LocalDate getFechaCierreDeInscripcion(){return this.fechaCierreDeInscripcion;}
    public Ciudad getCiudad(){return this.ciudad;}
    public String getLugar(){return this.lugar;}
    public String getPremios(){return this.premios;}
    public ArrayList<Auspiciante> getAuspiciantes(){return this.getAuspiciantes();}
    public DirigidoA getDirigidoA(){return this.dirigidoA;}
    
    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDelEvento(LocalDate fechaDelEvento) {
        this.fechaDelEvento = fechaDelEvento;
    }

    public void setHoraDelEvento(String horaDelEvento) {
        this.horaDelEvento = horaDelEvento;
    }

    public void setFechaInicioDeInscripcion(LocalDate fechaInicioDeInscripcion) {
        this.fechaInicioDeInscripcion = fechaInicioDeInscripcion;
    }

    public void setFechaCierreDeInscripcion(LocalDate fechaCierreDeInscripcion) {
        this.fechaCierreDeInscripcion = fechaCierreDeInscripcion;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public void setAusDelConcurso(ArrayList<Auspiciante> AusDelConcurso) {
        this.AusDelConcurso = AusDelConcurso;
    }

    public void setDirigidoA(DirigidoA dirigidoA) {
        this.dirigidoA = dirigidoA;
    }
    
    
    //Métodos    
    
    //metodo para generar codigo
    public String generarCodigo(){
        //- se toma los tres primeros caracteres de los atributos de tipo String
        char ch1 = getNombre().charAt(0);
        char ch2 = getPremios().charAt(0);
        char ch3 = getNombre().charAt(1);
        char ch4 = getPremios().charAt(1);
        char ch5 = getNombre().charAt(2);
        char ch6 = getPremios().charAt(2);
        String cod = String.valueOf(ch1+ch2+ch3+ch4+ch5+ch6);
        return cod;//se devuelve un string de 6 caracteres
    }
    
        
    //metodo para escoger el premio segun el lugar (enum)
    public static String premioSegunAus(ArrayList<Auspiciante> lAus){
        //se itera cada auspiciante relacionado al concurso
        String todoAus = "";
        for (Auspiciante a : lAus){
            todoAus += a+", ";
            }
        return "Primer lugar: $200 y productos "+ todoAus +"auspiciante "+ todoAus +"\n"
                        + "Segundo lugar: $100 y productos "+ todoAus +"auspiciante "+ todoAus +"\n"
                        +"Tercer lugar: $150 y productos "+ todoAus +"auspiciante "+ todoAus +"\n";}
    
    //con este metodo se muestra la lista de mascotas (lista con datos de tipo Mascota)
    //ademas si el concurso esta abierto --> se puede ingresar una mascota(con sus datos de clase Mascota)a la lista de mascotas
    //si el concurso esta cerrado --> se podra visualizar los ganadores 
    public void inscribirParticipante (ArrayList<Mascota> lm, ArrayList<Mascota> lMasIns, ArrayList<Mascota> lg,ArrayList<Duenio> ld, Boolean concursoabierto){
        System.out.println("A continuación se muestran las mascotas en el concurso");
       for (Mascota ma: lMasIns){//se itera cada elemento de la lista
           System.out.print(ma.toString());}//se imprime el elemento
        if(concursoabierto){//confirmar si el concurso sigue abierto
            System.out.println("Las inscripciones estan abiertas\n" + 
                    "Se presentan las mascotas creadas");
            Scanner sc = new Scanner(System.in);
            
            int c = 1;
            //se muestran las mascotas creadas
            for (Mascota m: lm){//se itera cada elemento de la lista
                System.out.println(c + "." + m.toString());
                c++;}//se imprime el elemento
            //se indica que escoja un numero segun lo presentado
            System.out.print("Escoger mascotar(ingrese numero):");
            int res = sc.nextInt();//se ingresa el numero
            Mascota resMas = lm.get(res);//se escoge la mascota de la lista de las mascotas creadas segun el numero
            lMasIns.add(resMas);//se anade la mascota a la lista de mascotas inscritas
            //nota: lo que se hizo aqui es simplemente obtener una mascota de una lista y anadirla a otra
            ////////////////////////////////////////////////////////////////////////////////////////////////
            
        }else if(concursoabierto.equals(false)){//confirmar si el concurso esta cerrado
            System.out.println("El concurso ha finalizado, \n"
                    + "A conituación los ganadores del concurso:");
            for (Mascota g: lg){//se itera cada elemento de la lista de ganadores
                System.out.print(g.toString());}//se imprime el elemento
        }}
    
            
    @Override
    public String toString(){
        String aus = "";
        for (Auspiciante a : this.AusDelConcurso){
            aus += " -"+a.getNombre();}
            
        return "Nombre del concurso: " + this.nombre + "\nFecha del evento: " + this.fechaDelEvento + "\nHora del evento: " 
                +this.horaDelEvento + "\nFecha de Inicio de Inscripcion: " + this.fechaInicioDeInscripcion + "\nFecha de cierre de inscripcion: "
                +this.fechaCierreDeInscripcion + "\nCiudad: " + this.ciudad.toString() + "\nLugar: " + this.lugar + "\nPremios: "
                +this.premios + "\n Auspiciante del evento: " + aus + "\nDirigido a: " + this.dirigidoA;}
    
      
}
