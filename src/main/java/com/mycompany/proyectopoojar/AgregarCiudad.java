/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoojar;

import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
/**
 *
 * @author PC
 */
public class AgregarCiudad {
    private Text nombre;
    private ComboBox<String> cM;
    private ArrayList<String> provincias = new ArrayList<>();
    private int indice=4;
    private TableView tabla = new TableView();

    @FXML
    private void switchToAdministrarCiudad() throws IOException{
        try {
               App.setRoot("AdministrarCiudades");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }

    }
    @FXML
    private void cerrarVentana() {
        Stage stage = (Stage) nombre.getScene().getWindow();
        stage.close();
    }
    
     public String guardarNombre(){
       return nombre.getText();
   }
     public void llenarCombo(){
         try {
            FileReader reader = new FileReader("src/main/java/com/mycompany/files/ciudades.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] list=line.split(",");
                provincias.add(list[2]);
                for(String e: provincias){
                    cM.getItems().add(e);
                }
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }}
     public void guardar(){
        String text = nombre.getText();
        if (!(text.isEmpty()) && !(cM.getValue().isEmpty()) ){
            try {
            FileWriter writer = new FileWriter("src/main/java/com/mycompany/files/ciudades.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            indice++;
            bufferedWriter.write(indice+","+nombre.getText()+","+cM.getValue()+"\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();            
        }
                    
        }else{
            Alert a2=new Alert(Alert.AlertType.WARNING,"No dejar campos vacíos.");
           a2.show();
    }
        cerrarVentana();
    }
     public void llenarTabla(){
         
     }
     }
    

         
     

