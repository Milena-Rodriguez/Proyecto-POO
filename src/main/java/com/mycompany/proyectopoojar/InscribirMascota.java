/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoojar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author arian
 */
public class InscribirMascota implements Initializable {


    @FXML
    private ComboBox<String> ConcursoDis;
    @FXML
    private ComboBox<String> MascotaDis;
    @FXML
    private Button Inscribir;
    @FXML
    private Button Menu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToPrimary(ActionEvent event) {
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
