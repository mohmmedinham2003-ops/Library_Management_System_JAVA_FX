package controllers.message;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SuccessMessageController {

    @FXML
    private Button btnAction;

    @FXML
    void closeOnAction(ActionEvent event) {
        System.exit(0);

    }

}
