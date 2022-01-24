package com.mycompany.proyectopoojar;

import com.mycompany.modelo.Mascota;
import com.mycompany.modelo.DirigidoA;
import com.mycompany.modelo.Duenio;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import java.time.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.scene.text.Text;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;






public class CrearMascota {
    private ComboBox<Duenio> cM;
    private TextField nombre;
    private TextField raza;
    private RadioButton perro;
    private RadioButton gato;
    private DatePicker fecha;
    private ToggleGroup group;
    private Mascota mascota;
    private Text ruta;
    private Label lbl;
    private TableView tabla;
    
    
    @FXML
    private void switchToPrimary() throws IOException {
        try {
               App.setRoot("primary");
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
    
   public void llenarCombo(){
       for(com.mycompany.modelo.Duenio d: com.mycompany.modelo.Duenio.cargarDuenios(App.pathCiudad)){
               cM.getItems().add(d);
        }
   }
   
   public String guardarNombre(){
       return nombre.getText();
   }
  
   public String guardarRaza(){
       return raza.getText();
   }
   
   public LocalDate Date(){
       return fecha.getValue();
    }
   
   public DirigidoA radioButtons(){
    perro.setToggleGroup(group);
    gato.setToggleGroup(group);
    if(perro.isSelected()){
        return com.mycompany.modelo.DirigidoA.PERROS;
    }else{
        return com.mycompany.modelo.DirigidoA.GATOS;
    }
   }
   @FXML
    public void adjuntarImg(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter ("JPG Files" , "*.jpg"));
        File imagen = fc.showOpenDialog(null);
        try{
            if(imagen!=null){
                ruta.setText(imagen.getAbsolutePath());
            }
        }catch(Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error");
            a.show();
        } 
    }
    @FXML
    private void cerrarVentana() {
        Stage stage = (Stage) nombre.getScene().getWindow();
        stage.close();
    }
   public void guardar(){
       if(nombre.getText().isEmpty() && raza.getText().isEmpty() && !(fecha.isPressed()) && !(group.getSelectedToggle()==perro || group.getSelectedToggle()==gato)){
           Alert a2=new Alert(Alert.AlertType.WARNING,"No dejar campos vacíos.");
           a2.show();
       }else{
           mascota.setNombre(guardarNombre());
           mascota.setRaza(guardarRaza());
           mascota.setPerroOGato(radioButtons());
           mascota.setFechaNacimiento(Date());
           mascota.setFoto(String.valueOf(ruta));
           mascota.setDuenio(cM.getValue());
           
           try {
            FileWriter writer = new FileWriter(App.pathMascotas, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write(mascota.generarCodigo()+";"+mascota.getNombre()+";"+mascota.getPerroOGato()+";"+mascota.getRaza()+";"+mascota.getFecha()+";"+mascota.getFoto()+";"+cM.getValue().getCedula()+"\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();            
        }try {
               App.setRoot("DetalleMascota");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
        cerrarVentana();
        //String n = nombre.getValue();
        //String s=String.valueOf(value.getStock());
        //lbl.setText(mascota.getNombre());
           
   }}
   
}

   

