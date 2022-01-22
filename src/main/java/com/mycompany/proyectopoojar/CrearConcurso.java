package com.mycompany.proyectopoojar;

import com.mycompany.modelo.DirigidoA;
import com.mycompany.modelo.Ciudad;
import com.mycompany.modelo.Auspiciante;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.time.*;
import java.io.IOException;
import javafx.fxml.FXML;

public class CrearConcurso {
    private ComboBox<DirigidoA> dA;
    private TextField nombre;
    private DatePicker fechaActual;
    private TextField hora;
    private DatePicker fechaInicio;
    private DatePicker fechaFin;
    private ArrayList<Ciudad> ciudades= new ArrayList<>();
    private ComboBox<Ciudad> ciuC;
    private TextField lugar;
    private ComboBox<Auspiciante> aus;
    @FXML
    private void switchToAdministrarConcurso() throws IOException {
        App.setRoot("AdministrarConcursos_1");
    }
    @FXML
    private void switchToAnadirpremio() throws IOException {
        App.setRoot("AgregarPremio");
    }
    @FXML
    private void switchToCrearConcurso() throws IOException {
        App.setRoot("CrearConcurso_1");
    }
    public void ComboDirigidoA(){
    for(DirigidoA d: DirigidoA.values()){
        dA.getItems().add(d);
        }
}
    public String nombre(){
        return nombre.getText();
    }
    public LocalDate fechaActual(){
        return fechaActual.getValue();
    }
    public String hora(){
        return hora.getText();
    }
    public LocalDate fechaInicio(){
        return fechaInicio.getValue();
    }
    public LocalDate fechaFin(){
        return fechaFin.getValue();
    }
    public void comboCiudad(){
        try {
            FileReader reader = new FileReader(App.pathCiudad);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] list=line.split(",");
                ciudades.add(new Ciudad(list[1],list[2]));
                for(Ciudad c: ciudades){
                    ciuC.getItems().add(c);
                }
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String lugar(){
        return lugar.getText();
    }
    public void comboAuspi(){
        
    }
}