/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoojar;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author PC
 */
public class AdministrarCiudad {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchToAgregarCiudad() throws IOException{
        App.setRoot("AgregarCiudades");
    }
    
}
