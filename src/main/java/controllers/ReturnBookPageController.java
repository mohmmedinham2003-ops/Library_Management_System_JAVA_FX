package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReturnBookPageController {
    Stage stage = new Stage();

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnBack;

    @FXML
    private DatePicker dtpBorrowedDate;

    @FXML
    private DatePicker dtpDueDate;

    @FXML
    private DatePicker dtpReturnedDate;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/main_dashboard.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

}
