package com.mycompany.proyectopoojar;

import com.mycompany.proyectopoojar.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class AdministrarConcurso {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchToCrearConcurso() throws IOException {
        App.setRoot("CrearConcurso_1");
    }
}