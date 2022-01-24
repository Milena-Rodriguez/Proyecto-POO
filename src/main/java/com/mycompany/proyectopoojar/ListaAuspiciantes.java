package com.mycompany.proyectopoojar;

import com.mycompany.modelo.Auspiciante;
import com.mycompany.modelo.Ciudad;
import com.mycompany.modelo.Duenio;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

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
    
     private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPag.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        agregarOpciones();//en este metodo se llenan los botones para cada fila

        //datos en listview
        tvAuspiciante.getItems().setAll(Auspiciante.cargarAuspiciante(App.pathDuenio));
    }
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
    
    private void agregarOpciones() {

        Callback<TableColumn<Auspiciante, Void>, TableCell<Auspiciante, Void>> cellFactory = new Callback<TableColumn<Auspiciante, Void>, TableCell<Auspiciante, Void>>() {
            @Override
            public TableCell<Auspiciante, Void> call(final TableColumn<Auspiciante, Void> param) {
                TableCell<Auspiciante, Void> cell = new TableCell<Auspiciante, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            //hbox para ubicar los botones
                            HBox hbOpciones = new HBox(5);
                            //recuperar el empleado de la fila
                            Auspiciante a = getTableView().getItems().get(getIndex());
                            //boton editar
                            Button btnEd = new Button("Editar");
                            btnEd.setOnAction(e ->eliminarAuspiciante(a));
                               
                            //boton eliminar
                            Button btnEl = new Button("Eliminar");
                            btnEl.setOnAction(e -> eliminarAuspiciante(a));
                            //se agregan botones al hbox
                            hbOpciones.getChildren().addAll(btnEd,btnEl);
                            //se ubica hbox en la celda
                            setGraphic(hbOpciones);
                        }
                    }
                };
                return cell;
            }
        };

        colOpc.setCellFactory(cellFactory);

    }
     private void eliminarAuspiciante(Auspiciante a) {

        System.out.println("duenio : " + a);

    }

}
