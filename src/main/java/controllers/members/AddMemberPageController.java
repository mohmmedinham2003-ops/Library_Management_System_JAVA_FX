package controllers.members;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MemberDTO;
import scene.SceneManager;

import java.io.IOException;

public class AddMemberPageController {
AddMemberController addMemberController = new AddMemberController();
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
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtPhoneNumber;


    @FXML
    void btnAddOnAction(ActionEvent event) {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setFullName(txtFullName.getText());
        memberDTO.setEmail(txtEmail.getText());
        memberDTO.setPhoneNumber(txtPhoneNumber.getText());
        memberDTO.setAddress(txtAddress.getText());

        if (memberDTO.getFullName() ==  null || memberDTO.getFullName().trim().isEmpty() ||
            memberDTO.getEmail() == null || memberDTO.getEmail().trim().isEmpty() ||
            memberDTO.getPhoneNumber() == null || memberDTO.getPhoneNumber().trim().isEmpty() ||
            memberDTO.getAddress() == null || memberDTO.getAddress().trim().isEmpty()
        ){
            new Alert(Alert.AlertType.WARNING,"Please fill the required fields").show();
        }

        try{
        boolean isAdd = addMemberController.addMember(memberDTO);
            if (isAdd){
                new Alert(Alert.AlertType.CONFIRMATION,"Member Added Successfully!!!").show();

            }else {
                new Alert(Alert.AlertType.ERROR,"Faild to Add member!!!").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Error processing!!!");
        }
    }


//        if (addMemberController.addMember(txtFullName.getText(),txtEmail.getText(),txtPhoneNumber.getText(),txtAddress.getText())){
//            try {
//                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/success_message_page.fxml"))));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            stage.show();
//        }
//        else{
//            try {
//                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/fail_message_page.fxml"))));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            stage.show();
//
//        }
//    }

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




    public void btnClearOnAction(ActionEvent actionEvent) {
        txtFullName.clear();
        txtEmail.clear();
        txtPhoneNumber.clear();
        txtAddress.clear();
    }
}
