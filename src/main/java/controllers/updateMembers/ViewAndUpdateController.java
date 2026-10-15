package controllers.updateMembers;

import controllers.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAndUpdateController {

    public ObservableList<Integer> loadMembers() {
        Connection connection = DBConnection.getInstance().getConnection();
        ObservableList<Integer> members = FXCollections.observableArrayList();
        String SQL = "SELECT member_id FROM members";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                members.add(resultSet.getInt("member_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return members;

    }

    public boolean updateMember(int member_id, String full_name, String email, String phone_number, String address) {
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "UPDATE members SET full_name = ?,email = ?,phone_number = ?,address = ? WHERE member_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,full_name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,phone_number);
            preparedStatement.setString(4,address);
            preparedStatement.setInt(5,member_id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
