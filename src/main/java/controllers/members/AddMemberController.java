package controllers.members;

import controllers.db.DBConnection;
import model.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMemberController {

    public boolean addMember(MemberDTO memberDTO) {
        Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "INSERT INTO members(full_name,email,phone_number,address) VALUES(?, ?, ?, ?)";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1,memberDTO.getFullName());
                preparedStatement.setString(2,memberDTO.getPhoneNumber());
                preparedStatement.setString(3,memberDTO.getPhoneNumber());
                preparedStatement.setString(4,memberDTO.getAddress());


                preparedStatement.executeUpdate();
                return true;


            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
    }

}

