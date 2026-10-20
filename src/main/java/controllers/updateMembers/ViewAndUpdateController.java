package controllers.updateMembers;

import controllers.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ViewAndUpdateController {
    Connection connection = DBConnection.getInstance().getConnection();

    public ObservableList<Integer> loadMembers() {
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

    public ObservableList<Map<String, String>> getAllMembers(){
        ObservableList<Map<String, String>> membersList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM members ORDER BY member_id ASC";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Map<String,String> row = new HashMap<>();
                row.put("member_id", String.valueOf(resultSet.getInt("member_id")) != null ? String.valueOf(resultSet.getInt("member_id")) : "");
                row.put("full_name", resultSet.getString("full_name") != null ? resultSet.getString("full_name") : "");
                row.put("email",resultSet.getString("email") != null ? resultSet.getString("email") : "");
                row.put("phone_number",resultSet.getString("phone_number") != null ? resultSet.getString("phone_number") : "");
                row.put("address",resultSet.getString("address") != null ? resultSet.getString("address") : "");

                membersList.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return membersList;
    }


}
