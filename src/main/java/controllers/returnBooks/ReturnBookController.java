package controllers.returnBooks;

import controllers.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReturnBookController {

    Connection connection = DBConnection.getInstance().getConnection();

    public boolean returnBooks(Object book_id, Object member_id, String full_name, String phone_number, String address, LocalDate borrowed_date, LocalDate due_date, LocalDate returned_date) {

    return true;
    }

    public ObservableList<Integer> getAllBooks() {
        ObservableList<Integer> getBooks = FXCollections.observableArrayList();
        String SQL = "SELECT book_id FROM books";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                getBooks.add(resultSet.getInt("book_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getBooks;

    }

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
}
