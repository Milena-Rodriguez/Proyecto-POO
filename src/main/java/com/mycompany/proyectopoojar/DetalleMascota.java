/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoojar;

import com.mycompany.proyectopoojar.CrearMascota;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 *
 * @author PC
 */
public class DetalleMascota {
    @FXML
    private void switchToCrearMascota() throws IOException {
        try {
               App.setRoot("primary");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    public void llenarInfo(){
    //String n = CrearMascota.guardarNombre();
      //  String s=String.valueOf(value.getStock());
        //lbl.setText(mascota.getNombre());
}
}

