module com.example.extendedcalulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.extendedcalulator to javafx.fxml;
    exports com.example.extendedcalulator;
    exports com.example.ui;
    opens com.example.ui to javafx.fxml;
    exports com.example;
    opens com.example to javafx.fxml;
}