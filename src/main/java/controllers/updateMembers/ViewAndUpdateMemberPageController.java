package controllers.updateMembers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import scene.SceneManager;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ViewAndUpdateMemberPageController implements Initializable {
    ViewAndUpdateController viewAndUpdateController = new ViewAndUpdateController();
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
    private ComboBox<Integer> cmbSelectMember;

    @FXML
    private TableColumn<Map<String, String>, String> colAddress;

    @FXML
    private TableColumn<Map<String, String>, String>colEmail;

    @FXML
    private TableColumn<Map<String, String>, String>colFullName;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberId;
    @FXML
    private TableColumn<Map<String, String>, String> colPhoneNumber;

    @FXML
    private TableView<Map<String, String>> tblViewUpdateMember;


    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
    if(viewAndUpdateController.updateMember(cmbSelectMember.getValue(),txtFullName.getText(),txtEmail.getText(),txtPhoneNumber.getText(),txtAddress.getText())){
        System.out.println("success");
    }else{
        System.out.println("fail");
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


    private void initializeColumn(){
        colMemberId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_id","")));
        colFullName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("full_name"," ")));
        colEmail.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("email","")));
        colPhoneNumber.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("phone_number","")));
        colAddress.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("address","")));

    }

    public void fillUpdateDetails(String full_name,String email,String phone_number,String address){
    txtFullName.setText(full_name);
    txtEmail.setText(email);
    txtPhoneNumber.setText(phone_number);
    txtAddress.setText(address);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbSelectMember.setItems(viewAndUpdateController.loadMembers());
        initializeColumn();
       tblViewUpdateMember.setItems(viewAndUpdateController.getAllMembers());


        cmbSelectMember.setOnAction(event -> {
            Integer memberId = cmbSelectMember.getValue();

            if(memberId != null){
                viewAndUpdateController.loadUpdateList(memberId, this);
            }

        });

    }
}
