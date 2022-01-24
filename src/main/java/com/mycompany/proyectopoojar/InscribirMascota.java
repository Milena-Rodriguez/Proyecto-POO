/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoojar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ComboBox<String> ConcursoDis;
    @FXML
    private ComboBox<String> MascotaDis;
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
    /**
     * Initializes the controller class.
     */
    public void initialize() {
          System.out.println("sisis");
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
        
    }

    @FXML
    private void FiltrarMascota(ActionEvent event) {
    }

    @FXML
    private void InscribirMas(ActionEvent event) {
    }

}
