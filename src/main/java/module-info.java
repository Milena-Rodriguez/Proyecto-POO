module com.mycompany.proyectopoojar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.mail;

    opens com.mycompany.proyectopoojar to javafx.fxml;
    opens com.mycompany.modelo to javafx.base;
    exports com.mycompany.proyectopoojar;
}
