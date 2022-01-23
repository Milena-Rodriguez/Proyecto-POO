/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoojar;

import com.mycompany.modelo.Auspiciante;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
/**
 *
 * @author PC
 */
public class AgregarPremio {
    private ComboBox<Auspiciante> cA;
    private TextField lugar;
    private TextField descripcion;
    
    
    @FXML
    public String lugarA(){
        return lugar.getText();
    }
    public String descripcion(){
        return descripcion.getText();
    }
    public void comboAuspiciantes(){
        for(Auspiciante a: cargarAuspiciantes()){
            cA.getItems().add(a);
        }
    }
    public void guardar(){
        if(lugar.getText().isEmpty() && descripcion.getText().isEmpty() && cA.getItems().isEmpty()){
            Alert a2=new Alert(Alert.AlertType.WARNING,"No dejar campos vacíos.");
           a2.show();
        }else{
            try {
            FileWriter writer = new FileWriter(App.pathPremios,false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write(lugar.getText()+","+descripcion.getText()+","+cA.getItems()+"\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();            
        }
        }
    }
}
