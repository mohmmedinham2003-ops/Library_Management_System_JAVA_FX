package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainDashboardController {

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
    void btnAddBooksOnAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_book_page.fxml"))));
        stage.show();
    }

    @FXML
    void btnAddmembersOnAction(ActionEvent event) {

    }

    @FXML
    void btnBorrowingHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdatemembersOnAction(ActionEvent event) {

    }

}
