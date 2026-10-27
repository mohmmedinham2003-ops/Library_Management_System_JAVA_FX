package mainDashboard;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import scene.SceneManager;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainDashboardController implements Initializable {
    DashboardController dashboardController = new DashboardController();
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
    private TableView<Map<String,String>> tbllDashboardView;

    @FXML
    private TableColumn<Map<String, String> ,String> colBookId;

    @FXML
    private TableColumn<Map<String, String>,String> colBookName;

    @FXML
    private TableColumn<Map<String, String>, String> colBorrower;

    @FXML
    private TableColumn<Map<String, String>,String> colDueDate;

    @FXML
    private TableColumn<Map<String, String> ,String> colIssuedate;




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

    public void loadMaintabble(){
        colBookId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_id","")));
        colBookName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_title","")));
        colBorrower.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("full_name","")));
        colIssuedate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("issue_date","")));
        colDueDate.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("due_date","")));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadMaintabble();
        tbllDashboardView.setItems(dashboardController.loadDetails());
    }
}
