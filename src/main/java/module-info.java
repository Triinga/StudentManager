module com.example.exercise1softwaretesting {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.exercise1softwaretesting to javafx.fxml;
    opens com.example.exercise1softwaretesting.gui to javafx.fxml;

    exports com.example.exercise1softwaretesting;
    exports com.example.exercise1softwaretesting.gui to javafx.graphics;
    exports com.example.exercise1softwaretesting.database to javafx.graphics;


}