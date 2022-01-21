package com.mycompany.proyectopoojar;

import com.mycompany.proyectopoojar.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class AgregarPremioController {
     @FXML
    private void switchToCrearConcurso() throws IOException {
        App.setRoot("AgregarPremio");
    }

}