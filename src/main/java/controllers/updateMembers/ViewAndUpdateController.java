package controllers.updateMembers;

import controllers.db.DBConnection;

import java.sql.Connection;

public class ViewAndUpdateController {

    public boolean updateMember(String full_name, String email, String phone_number, String address) {
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "UPDATE members SET full_name = ?,email = ?,phone_number = ?,address = ? WHERE member_id = ?";
        return false;
    }
}
