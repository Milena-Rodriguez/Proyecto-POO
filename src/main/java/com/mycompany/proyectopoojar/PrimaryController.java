package com.mycompany.proyectopoojar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class PrimaryController implements Initializable{
    
    
    @FXML
    private void switchTolistaDuenio() throws IOException {
        try {
               App.setRoot("ListaDuenio");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchToAdministrarMascota() throws IOException{
        try {
               App.setRoot("AdministrarMascota");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchToListaAuspiciantes() throws IOException{
        try {
               App.setRoot("ListaAuspiciantes");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchToAdministrarConcursos_1() throws IOException{
        try {
               App.setRoot("AdministrarConcursos_1");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchToInscribirMascota() throws IOException{
        try {
               App.setRoot("InscribirMascota");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchToAdministrarCiudades() throws IOException{
        try {
               App.setRoot("AdministrarCiudades");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
