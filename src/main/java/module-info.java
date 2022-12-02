module com.example.uygulama2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uygulama2 to javafx.fxml;
    exports com.example.uygulama2;
}