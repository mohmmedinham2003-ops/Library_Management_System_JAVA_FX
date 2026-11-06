package controllers.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.BookDTO;
import scene.SceneManager;

import java.io.IOException;

public class AddBookPageController {
    AddBookController addBookController = new AddBookController();
    Stage stage = new Stage();
    @FXML
    private Button btnAdd;

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
    private Button btnUpdatemembers;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    private TextField txtQuantity;


    @FXML
    void btnAddOnAction(ActionEvent event) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookTitle(txtBookTitle.getText());
        bookDTO.setAuthor(txtAuthor.getText());
        bookDTO.setCategory(txtCategory.getText());
        bookDTO.setPublishedyear(Integer.parseInt(txtPublishedYear.getText()));
        bookDTO.setQuantity(Integer.parseInt(txtQuantity.getText()));

        if (bookDTO.getBookTitle() == null || bookDTO.getBookTitle().trim().isEmpty() ||
            bookDTO.getAuthor() == null || bookDTO.getAuthor().trim().isEmpty() ||
            bookDTO.getCategory() == null || bookDTO.getCategory().trim().isEmpty() ||
            bookDTO.getPublishedyear() == 0 ||
            bookDTO.getQuantity() == 0
        ){
            new Alert(Alert.AlertType.WARNING,"Please fill the required fields").show();
        }

        try{
            boolean isAdd = addBookController.addBook(bookDTO);
            if (isAdd){
                new Alert(Alert.AlertType.CONFIRMATION,"Book Added Successfully!!!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Book failed to Add!!!").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Error processing!!!").show();
        }

//        if(addBookController.addbook(txtBookTitle.getText(),txtAuthor.getText(),txtCategory.getText(),Integer.parseInt(txtPublishedYear.getText()),Integer.parseInt(txtQuantity.getText()))){
//            try {
//                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/success_message_page.fxml"))));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            stage.show();
//        }else{
//            try {
//                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/fail_message_page.fxml"))));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            stage.show();
//
//        }
    }



    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtBookTitle.clear();
        txtAuthor.clear();
        txtCategory.clear();
        txtPublishedYear.clear();
        txtQuantity.clear();
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



}
