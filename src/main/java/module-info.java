module com.mycompany.proyecto.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyecto.poo to javafx.fxml;
    exports com.mycompany.proyecto.poo;
}
