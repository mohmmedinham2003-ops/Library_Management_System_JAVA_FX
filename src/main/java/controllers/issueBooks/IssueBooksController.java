package controllers.issueBooks;

import controllers.db.DBConnection;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueBooksController {
    public boolean issuebooks() {
        return false;
    }

    public ObservableList<String> loadMembers(){
        ObservableList<String> members = FXCollections.observableArrayList();

        String SQL = "SELECT full_name FROM members";

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                members.add(resultSet.getString("full_name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;

    }

    public void loadBooks(){


    }

}
