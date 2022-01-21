package com.mycompany.proyectopoojar;

import java.io.IOException;
import javafx.fxml.FXML;

public class AdministrarMascotaController {
  

    @FXML
    private void switchToCrearMascota() throws IOException {
        App.setRoot("CrearMascota");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchTolistaDuenio() throws IOException {
        App.setRoot("listaDuenio");
    }
    
}
