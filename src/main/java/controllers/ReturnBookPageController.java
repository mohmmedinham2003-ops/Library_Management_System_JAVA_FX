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
import scene.SceneManager;

import java.io.IOException;

public class ReturnBookPageController {
    Stage stage = new Stage();

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddmembers;

    @FXML
    private Button btnBorrowingHistory;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnIssueBooks;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnReturnBooks;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdatemembers;

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
    void btnAddBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/main_dashboard.fxml");
    }

    @FXML
    void btnAddmembersOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/add_member_page.fxml");
    }

    @FXML
    void btnBorrowingHistoryOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/borrowing_history_page.fxml");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/main_dashboard.fxml");
    }

    @FXML
    void btnIssueBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/issue_books_page.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/login_page.fxml");
    }

    @FXML
    void btnReturnBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/return_book_page.fxml");
    }

    @FXML
    void btnUpdatemembersOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/view_and_update_member_page.fxml");
    }

    @FXML
    void btnMainAddBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/main_dashboard.fxml");
    }


}
