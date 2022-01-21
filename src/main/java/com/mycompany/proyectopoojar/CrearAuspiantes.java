package com.mycompany.proyectopoojar;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import com.mycompany.modelo.Ciudad;
import com.mycompany.modelo.Auspiciante;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CrearAuspiantes {
    
    @FXML
    private Button cancel;
    @FXML
    private Button guardar;
    private ComboBox<String> cc;
    private TextField txtfield0;
    private TextField txtfield1;
    private TextField txtfield2;
    private TextField txtfield3;
    private TextField txtfield4;

    private void switchToPrimary() throws IOException {
        try {
               App.setRoot("Primary");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchTolistaAuspiciantes() throws IOException {
        try {
               App.setRoot("ListaAuspiciantes");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    
    private void llenarComboBox(List<Ciudad> listaCiudad) {
        
        List<String> listaCiu = new ArrayList<>();
        List<Ciudad> ciudades =Ciudad.cargarCuiudades(App.pathCiudad);
        
        /*for (Ciudad c : ciudades) {
            String nom = c.getNombre();
            
            if (!listaCiu.contains(nom)) {
                listaCiu.add(nom);
            }}*/
        //con expresion lambda
        listaCiu = ciudades.stream()
                                .map(c -> c.getNombre())
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList());
        
        cc.getItems().addAll(listaCiu);
       } 
    
    private void GuardarAuspiciante(){
        if(guardar.isPressed()){
            String txt0 = txtfield0.getText();
            String txt1 = txtfield1.getText();
            String txt2 = txtfield2.getText();
            String txt3 = txtfield3.getText();
            String txt4 = txtfield4.getText();
            String ciudad = cc.getValue();
            FileOutputStream fos = null;
            ObjectOutputStream salida = null;
            if (!(txt0.isEmpty()) &&!(txt1.isEmpty()) &&!(txt2.isEmpty()) &&!(txt3.isEmpty()) &&!(txt4.isEmpty()) && !(ciudad.isEmpty()) ){
            try {
            ArrayList<Ciudad> ciudades = Ciudad.cargarCuiudades(App.pathCiudad);
                for (Ciudad ccc : ciudades){
                    if(ccc.getNombre().equals(ciudad)){
                        Ciudad ciu = ccc;
                        //crear objeto y agregar a la lista
                       Auspiciante a = new Auspiciante(txt0,txt1,txt2,ciu,txt3,txt4);
                       fos = new FileOutputStream("/ficheros/Auspiciantes.dat");                                                 
                       salida = new ObjectOutputStream(fos);
                       salida.writeObject(a.toString());
                       }}
            } catch (FileNotFoundException e) {
                 e.getStackTrace();} 
            catch (IOException e) {
            e.getStackTrace(); 
            } finally {
            try {
                if(fos!=null){
                   fos.close();
                }
                if(salida!=null){
                   salida.close();
                }
            } catch (IOException e) {
                     System.out.println("3"+e.getMessage());
            }}
        }else{
            Alert a2=new Alert(Alert.AlertType.WARNING,"No dejar campos vacíos.");
           a2.show();
    }}}
}
