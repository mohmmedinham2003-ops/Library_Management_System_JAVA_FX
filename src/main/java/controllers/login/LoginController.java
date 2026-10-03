package controllers.login;

import javafx.scene.control.Alert;

public class LoginController {

    public boolean checkUsernameAndpassword(String name, String password) {
        if (name.equals("inham") && password.equals("1234")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null); // Removes the header space for a cleaner look
            alert.setContentText("Login successful! Redirecting to dashboard...");
            alert.showAndWait();
            return true;


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Authentication Error");
            alert.setHeaderText("Unauthorized Access");
            alert.setContentText("The credentials provided do not match our records.");
            alert.showAndWait();
            return false;
        }
    }

}
