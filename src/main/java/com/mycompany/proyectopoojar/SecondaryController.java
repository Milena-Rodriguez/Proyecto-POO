package com.mycompany.proyectopoojar;

import com.mycompany.modelo.Duenio;
import com.mycompany.modelo.Ciudad;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SecondaryController {
    
    @FXML
    private Button cancel;
    @FXML
    private Button guardar;
    @FXML
    private ComboBox<String> cc;
    @FXML
    private TextField txtfield0;
    @FXML
    private TextField txtfield1;
    @FXML
    private TextField txtfield2;
    @FXML
    private TextField txtfield3;
    @FXML
    private TextField txtfield4;
    @FXML
    private TextField txtfield5;

    private void switchToPrimary() throws IOException {
       try {
               App.setRoot("Primary");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchTolistaDuenio() throws IOException {
       try {
               App.setRoot("listaDuenio");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    
    private void llenarComboBox() {
        List<String> listaCiu = new ArrayList<>();
        List<Ciudad> ciudades = Ciudad.cargarCuiudades(App.pathCiudad);
        for (Ciudad c : ciudades) {
            String nom = c.getNombre();
            if (!listaCiu.contains(nom)) {
                listaCiu.add(nom);
            }}
        /*listaCiu = listaCiudad.stream()
        .map(c -> c.getNombre())
        .distinct()
        .sorted()
        .collect(Collectors.toList());*/
        cc.getItems().addAll(listaCiu);
       } 
    int partida = 32;
    private void GuardarDuenio(){
        if(guardar.isPressed()){
            String txt0 = txtfield0.getText();
            String txt1 = txtfield1.getText();
            String txt2 = txtfield2.getText();
            String txt3 = txtfield3.getText();
            String txt4 = txtfield4.getText();
            String txt5 = txtfield5.getText();
            String ciudad = cc.getValue();
            //Duenio d = new Duenio(txt0,txt1,txt2,txt3,txt4,ciudad,txt5);
            if (!(txt0.isEmpty()) &&!(txt1.isEmpty()) &&!(txt2.isEmpty()) &&!(txt3.isEmpty()) &&!(txt4.isEmpty()) &&!(txt5.isEmpty()) && !(ciudad.isEmpty()) ){
            try {
            FileWriter writer = new FileWriter(App.pathDuenio, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            partida++;
            bufferedWriter.write(partida+","+txt0+","+txt1+","+txt2+","+txt3+","+txt4+","+ciudad+","+txt5+"\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();            
        }
                    
        }else{
            Alert a2=new Alert(Alert.AlertType.WARNING,"No dejar campos vacíos.");
           a2.show();
    }
        }
    }
    
}