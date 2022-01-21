package com.mycompany.proyectopoojar;

import com.mycompany.proyectopoojar.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class CrearConcurso {
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
}