package controllers.login;

import controllers.db.DBConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    Connection connection = DBConnection.getConnection();

    public boolean checkUsernameAndpassword(String name, String password) {
      String SQL = "SELECT * FROM users";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String dbUsername = resultSet.getString("username");
                String dbPassword1 = resultSet.getString("password");
                System.out.println(dbUsername + " " + dbPassword1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
