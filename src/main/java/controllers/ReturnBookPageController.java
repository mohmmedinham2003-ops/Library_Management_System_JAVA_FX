package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReturnBookPageController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSave;

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

}
