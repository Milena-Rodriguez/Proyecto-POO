/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoojar;

import com.mycompany.modelo.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author arian
 */
public class InscribirMascota {


    @FXML
    private ComboBox<Concurso> ConcursoDis;
    @FXML
    private ComboBox<Mascota> MascotaDis;
    @FXML
    private Button Inscribir;
    @FXML
    private Label textEscogerCon;
    @FXML
    private Label txtEscMas;
    @FXML
    private Label txt0;
    @FXML
    private Label txt1;
    @FXML
    private Label txt2;
    @FXML
    private Button cancel;
    
    LocalDate fecha_hoy = LocalDate.now();
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        //ConcursoDis.getItems().setAll());
    }    
    
    @FXML
    private void switchToPrimary(ActionEvent event) {
        try {
               App.setRoot("primary");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }

    @FXML
    private void FiltrarConcurso(ActionEvent event) {
        ArrayList<Concurso> concursos = new ArrayList<>();
        for (Concurso c : Concurso.cargarConcursos(App.pathConcursos)){
            if(c.getFechaCierreDeInscripcion().isAfter(fecha_hoy)&&c.getFechaInicioDeInscripcion().isBefore(fecha_hoy)){
                System.out.println(c);
                concursos.add(c);
                }
        }
        ConcursoDis.getItems().setAll(concursos);
    }

    @FXML
    private void FiltrarMascota(ActionEvent event) {
        ArrayList<Mascota> mascotas = Mascota.cargarMascotas(App.pathMascotas);
        MascotaDis.getItems().setAll(mascotas);
    }

    @FXML
    private void InscribirMas(ActionEvent event) {
            Concurso con = ConcursoDis.getValue();
            Mascota mas = MascotaDis.getValue();
            if (!(con.equals(null)) &&!(mas.equals(null)) ){
            try {
              FileWriter writer = new FileWriter(App.pathDuenio, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(con.toString()+ ","+ mas.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();            
        }
        }else{
            Alert a2=new Alert(Alert.AlertType.WARNING,"No dejar campos vacíos.");
           a2.show();
    }}}
