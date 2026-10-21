package controllers.returnBooks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import scene.SceneManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReturnBookPageController implements Initializable {
    Stage stage = new Stage();
    ReturnBookController returnBookController = new ReturnBookController();

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
    private TextField txtFullName;

    @FXML
    private ComboBox<Integer> cmbBookId;

    @FXML
    private ComboBox<Integer> cmbMemberId;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(returnBookController.returnBooks(cmbBookId.getValue(),cmbMemberId.getValue(),txtFullName.getText(),txtPhoneNumber.getText(),txtAddress.getText(),dtpBorrowedDate.getValue(),dtpDueDate.getValue(),dtpReturnedDate.getValue())){
            System.out.println("Success");
        }else {
            System.out.println("failed");
        }
    }


    @FXML
    void btnAddBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/add_book_page.fxml");
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

    public void fillBorrowingDetails( int memberId, String fullName, String phoneNumber, String address, LocalDate borrowedDate, LocalDate dueDate){
       cmbMemberId.setValue(memberId);
       txtFullName.setText(fullName);
       txtPhoneNumber.setText(phoneNumber);
       txtAddress.setText(address);
       dtpBorrowedDate.setValue(borrowedDate);
       dtpDueDate.setValue(dueDate);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbBookId.setItems(returnBookController.getAllBooks());
        cmbMemberId.setItems((returnBookController.loadMembers()));


    }
}
