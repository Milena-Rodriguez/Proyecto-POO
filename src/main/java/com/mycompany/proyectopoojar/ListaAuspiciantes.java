package com.mycompany.proyectopoojar;

import com.mycompany.modelo.Auspiciante;
import com.mycompany.modelo.Ciudad;
import com.mycompany.modelo.Duenio;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaAuspiciantes {   
    @FXML
    TableView<Auspiciante> tvAuspiciante;

    @FXML
    private TableColumn<Auspiciante, String> colNombre;
    @FXML
    private TableColumn<Auspiciante, String> colDireccion;
    @FXML
    private TableColumn<Auspiciante, String> colTelefono;
    @FXML
    private TableColumn<Auspiciante, String> colCiudad;
    @FXML
    private TableColumn<Auspiciante, String> colEmail;
    @FXML
    private TableColumn<Auspiciante, String> colPag;
    @FXML
    private TableColumn<Auspiciante, Void> colOpc;
    @FXML
    private void switchToCrearAuspiciantes() throws IOException {
        try {
               App.setRoot("CrearAuspiciantes");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchToPrimary() throws IOException {
        try {
               App.setRoot("Primary");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    public void llenarTabletView() {
        tvAuspiciante.getItems().setAll(Auspiciante.cargarAuspiciante(App.pathDuenio));
    }
}
