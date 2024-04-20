package com.example.exercise1softwaretesting.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static com.example.exercise1softwaretesting.database.sqliteDemo.*;

public class studentController {
    @FXML
    private TextArea OutputArea;


    @FXML
    private TextField addressField;

    @FXML
    private Button clearBtn;

    @FXML
    private TextField idField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField majorField;

    @FXML
    private Button modifyBtn;

    @FXML
    private TextField nameField;

    @FXML
    private Button removeBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private Button viewBtn;

    @FXML
    void addButton(ActionEvent event) {
        int id =Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String surname = lastNameField.getText();
        String major = majorField.getText();
        String address = addressField.getText();

        insertData(id, name, surname, address,major);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Data Inserted");
        alert.setHeaderText("Student Inserted");
        alert.showAndWait();
    }

    @FXML
    void modifyData(ActionEvent event){

        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String major = majorField.getText();
        String address = addressField.getText();
        updateData(id, name, lastName, address, major);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Data modified");
        alert.setHeaderText("Student modified!");
        alert.showAndWait();
    }

    @FXML
    void removeData(ActionEvent event){
            int id = Integer.parseInt(idField.getText());
            deleteData(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Data Deleted");
        alert.setHeaderText("Student Deleted");
        alert.showAndWait();
    }
    @FXML
    void clearData(ActionEvent event){
        idField.clear();
        nameField.clear();
        lastNameField.clear();
        majorField.clear();
        addressField.clear();
        OutputArea.clear();

    }

    public void setOutputAreaText(String text) {
        OutputArea.setText(text);
    }
    @FXML
    void viewButton(ActionEvent event) {
        selectAll(this);
    }


}
