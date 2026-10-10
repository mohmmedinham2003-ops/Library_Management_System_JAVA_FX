package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

public class IssueBooksPageController {
    Stage stage = new Stage();


    @FXML
    private Button btnClear;

    @FXML
    private Button btnIssue;

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<?> cmbSelectBook;

    @FXML
    private ComboBox<?> cmbSelectMember;

    @FXML
    private DatePicker dtpDueDate;

    @FXML
    private DatePicker dtpIssueDate;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueOnAction(ActionEvent event) {

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
