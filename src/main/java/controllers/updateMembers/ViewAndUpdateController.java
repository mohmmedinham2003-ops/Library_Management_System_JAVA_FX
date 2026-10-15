package controllers.updateMembers;

import controllers.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ViewAndUpdateController {

    public boolean updateMember(int member_id,String full_name, String email, String phone_number, String address) {
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "UPDATE members SET full_name = ?,email = ?,phone_number = ?,address = ? WHERE member_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,member_id);
            preparedStatement.setString(2,full_name);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,phone_number);
            preparedStatement.setString(5,address);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
