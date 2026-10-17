package controllers.issueBooks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import scene.SceneManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IssueBooksPageController implements Initializable {
    IssueBooksController issueBooksController = new IssueBooksController();
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
    private Button btnIssue;

    @FXML
    private Button btnIssueBooks;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnReturnBooks;

    @FXML
    private Button btnUpdatemembers;

    @FXML
    private ComboBox<Integer> cmbSelectBook;

    @FXML
    private ComboBox<Integer> cmbSelectMember;

    @FXML
    private DatePicker dtpDueDate;

    @FXML
    private DatePicker dtpIssueDate;


    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueOnAction(ActionEvent event) {
    if (issueBooksController.issuebooks(cmbSelectMember.getValue(),cmbSelectBook.getValue(),dtpIssueDate.getValue(),dtpDueDate.getValue())){
        System.out.println("Success");
    }else{
        System.out.println("fail");
    }


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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbSelectMember.setItems(issueBooksController.loadMembers());
        cmbSelectBook.setItems(issueBooksController.loadBooks());
    }
}

