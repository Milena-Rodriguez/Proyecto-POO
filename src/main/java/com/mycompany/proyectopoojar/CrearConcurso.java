package com.mycompany.proyectopoojar;

import com.mycompany.modelo.DirigidoA;
import com.mycompany.modelo.Ciudad;
import com.mycompany.modelo.Concurso;
import com.mycompany.modelo.Auspiciante;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.time.*;
import java.io.IOException;
import javafx.fxml.FXML;

public class CrearConcurso{
    private ComboBox<DirigidoA> dA;
    private TextField nombre;
    private DatePicker fechaEvento;
    private TextField hora;
    private DatePicker fechaInicio;
    private DatePicker fechaFin;
    private ArrayList<Ciudad> ciudades= new ArrayList<>();
    private ComboBox<Ciudad> ciuC;
    private TextField lugar;
    private ComboBox<Auspiciante> aus;
    private Concurso concurso;
    private ArrayList<Concurso> concursoL= new ArrayList<>();
    
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
    @FXML
    public void comboDirigidoA(){
    for(DirigidoA d: DirigidoA.values()){
        dA.getItems().add(d);
        }
}   @FXML
    public String nombre(){
        return nombre.getText();
    }
    @FXML
    public LocalDate fechaEvento(){
        return fechaEvento.getValue();
    }
    @FXML
    public String hora(){
        return hora.getText();
    }
    @FXML
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
    @FXML
    public String lugar(){
        return lugar.getText();
    }
    @FXML
    public void comboAuspi(){
        try {
            FileReader reader = new FileReader(App.pathAus);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {;
                //aus.getItems().add(line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardar(){
        
        if(dA.getItems().isEmpty() && nombre.getText().isEmpty() && !(fechaEvento.isPressed()) && hora.getText().isEmpty() && !(fechaInicio.isPressed()) && !(fechaFin.isPressed()) && ciuC.getItems().isEmpty() && lugar.getText().isEmpty() && aus.getItems().isEmpty()){
          Alert a2=new Alert(Alert.AlertType.WARNING,"No dejar campos vacíos.");
           a2.show();
        }else{
            concurso.setNombre(nombre());
            concurso.setFechaDelEvento(fechaEvento());
            concurso.setHoraDelEvento(hora());
            concurso.setFechaInicioDeInscripcion(fechaInicio());
            concurso.setFechaCierreDeInscripcion(fechaFin());
            concurso.setCiudad(ciuC.getValue());
            concurso.setLugar(lugar());
            concurso.setPremios(lugarA());
            concurso.setAusDelConcurso(aus);
            concurso.setDirigidoA(dA.getValue());
            concursoL.add(concurso);
        }
    }
}