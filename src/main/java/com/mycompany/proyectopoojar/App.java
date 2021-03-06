package com.mycompany.proyectopoojar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathCiudad = "com/mycompany/files/ciudades.csv";
    public static String pathDuenio="com/mycompany/files/duenosP5.csv";
    public static String pathAus="archivos/Auspiciantes.ser";
    public static String pathMascotas="com/mycompany/files/mascotas.csv";
    public static String pathPremios="com/mycompany/files/premios.csv";
    public static String pathConcursos="archivos/concursos.ser";
    public static String pathMacotasIns="com/mycompany/files/mascotasIns.csv";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    //metodo para cambiar el contenido de la escena
    static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
    }

}