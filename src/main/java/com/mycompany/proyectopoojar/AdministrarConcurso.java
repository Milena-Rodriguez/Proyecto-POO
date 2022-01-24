package com.mycompany.proyectopoojar;

import com.mycompany.modelo.Concurso;
import com.mycompany.proyectopoojar.App;
import com.mycompany.utils.Correo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class AdministrarConcurso {

    @FXML
    private TableColumn<Concurso, String> colCod;
    @FXML
    private TableColumn<Concurso, String> colNom;
    @FXML
    private TableColumn<Concurso, String> colFecha;
    @FXML
    private TableColumn<Concurso, String> ColCiudad;
    @FXML
    private TableColumn<Concurso, Void> colOpc;
    @FXML
    private Button switchToCrearConcurso;
    @FXML
    private Button switchToPrimary;
    @FXML
    private Label txtEstado;
    @FXML
    private Button enviarCorreo;
    @FXML
    private TableView<Concurso> tvConcursos;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary"); 
    }
    @FXML
    private void switchToCrearConcurso() throws IOException {
        App.setRoot("CrearConcurso_1");
    }

    @FXML
    private void ejecutarCorreo(ActionEvent event) {
         System.out.println("Enviando correo...");
        txtEstado.setText("Enviando correo...");
        String destinatario = "ariana.san00000000@gmail.com";//correo final, cambiar despues-- pooespol@gmail.com
        String asunto = "Prueba de correo 23 de enero";
        String cuerpo = "Cuerpo de email.  Saludos.";
        Correo.enviarCorreo(destinatario, asunto, cuerpo);
        System.out.println("Correo enviado!");
        txtEstado.setText("Correo enviado!");
    }
    public void llenarTabletView() {
        tvConcursos.getItems().setAll(Concurso.cargarConcursos(App.pathConcursos));
    }
}