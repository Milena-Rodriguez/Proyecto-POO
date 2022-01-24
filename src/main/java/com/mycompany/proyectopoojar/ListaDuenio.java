package com.mycompany.proyectopoojar;

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

public class ListaDuenio {
    
    @FXML
    TableView<Duenio> tvDuenio;
    @FXML
    private TableColumn<Duenio, String> colCedula;
    @FXML
    private TableColumn<Duenio, String> colNombre;
    @FXML
    private TableColumn<Duenio, String> colApellido;
    @FXML
    private TableColumn<Duenio, String> colDireccion;
    @FXML
    private TableColumn<Duenio, String> colTelefono;
    @FXML
    private TableColumn<Duenio, String> colCiudad;
    @FXML
    private TableColumn<Duenio, String> colEmail;
    @FXML
    private TableColumn<Duenio, Void> colOpc;
    
    @FXML
    private void switchToPrimary() throws IOException {
        try {
               App.setRoot("Primary");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
    @FXML
    private void switchToSecondary() throws IOException {
        try {
               App.setRoot("Secondary");
           } catch (IOException ex) {
               Alert a=new Alert(Alert.AlertType.ERROR,"Error");
                a.show();
           }
    }
     
    @FXML
    private void initialize() {
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        agregarOpciones();//en este metodo se llenan los botones para cada fila

        //datos en listview
        tvDuenio.getItems().setAll(Duenio.cargarDuenios(App.pathDuenio));
    }
    
    public void llenarTabletView() {
        tvDuenio.getItems().setAll(Duenio.cargarDuenios(App.pathDuenio));
    }
    
     private void agregarOpciones() {

        Callback<TableColumn<Duenio, Void>, TableCell<Duenio, Void>> cellFactory = new Callback<TableColumn<Duenio, Void>, TableCell<Duenio, Void>>() {
            @Override
            public TableCell<Duenio, Void> call(final TableColumn<Duenio, Void> param) {
                TableCell<Duenio, Void> cell = new TableCell<Duenio, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            //hbox para ubicar los botones
                            HBox hbOpciones = new HBox(5);
                            //recuperar el empleado de la fila
                            Duenio d = getTableView().getItems().get(getIndex());
                            //boton editar
                            Button btnEd = new Button("Editar");
                            btnEd.setOnAction(e ->eliminarDuenio(d));
                               
                            //boton eliminar
                            Button btnEl = new Button("Eliminar");
                            btnEl.setOnAction(e -> eliminarDuenio(d));
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
     private void eliminarDuenio(Duenio d) {

        System.out.println("duenio : " + d);

    }

}
