package controllers.borrowingHistory;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import scene.SceneManager;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class BorrowingHistoryPageController implements Initializable {
    BorrowingHistoryController borrowingHistoryController = new BorrowingHistoryController();
    Stage stage = new Stage();
    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddmembers;

    @FXML
    private Button btnBorrowingHistory;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnIssueBooks;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnReturnBooks;

    @FXML
    private Button btnUpdatemembers;

    @FXML
    private TableView<Map<String, String>> tblBookBorrowingHistory;

    @FXML
    private TableColumn<Map<String, String>, String> colBookTitle;

    @FXML
    private TableColumn<Map<String, String>, String> colDueDate;

    @FXML
    private TableColumn<Map<String, String>, String> colIssueDate;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberId;
    @FXML
    private TableColumn<Map<String, String>, String> colReturnDate;

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
    private void borrowingHistoryTable(){
        colMemberId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_id","")));
        colBookTitle.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_title","")));
        colIssueDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("issue_date","")));
        colDueDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("due_date","")));
        colReturnDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("returned_date","")));

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        borrowingHistoryTable();
        tblBookBorrowingHistory.setItems(borrowingHistoryController.getHistoryTable());
    }
}
