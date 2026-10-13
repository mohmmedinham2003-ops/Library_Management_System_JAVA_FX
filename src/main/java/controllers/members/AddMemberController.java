package controllers.members;

import controllers.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMemberController {

    public boolean addMember(String full_name, String email, String phone_number, String address) {
        Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "INSERT INTO members(full_name,email,phone_number,address) VALUES(?, ?, ?, ?)";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1,full_name);
                preparedStatement.setString(2,email);
                preparedStatement.setString(3,phone_number);
                preparedStatement.setString(4,address);


                preparedStatement.executeUpdate();
                return true;


            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
    }

}

