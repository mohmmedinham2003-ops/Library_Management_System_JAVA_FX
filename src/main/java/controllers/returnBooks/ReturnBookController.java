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
        String SQL = "SELECT book_id FROM issue_book";
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
        String SQL = "SELECT member_id FROM issue_book";
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

    public void loadBorrowList(int book_id){
        String SQL = """
                SELECT 
                    m.member_id,
                    m.full_name,
                    m.phone_number,
                    m.address,
                    i.issue_date,
                    i.due_date
                    FROM issue_book i
                    JOIN members m ON i.member_id = m.member_id
                    WHERE i.book_id = ?
                      
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1,book_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                resultSet.getInt("member_id");
                resultSet.getString("full_name");
                resultSet.getString("phone_number");
                resultSet.getString("address");
                resultSet.getDate("issue_date").toLocalDate();
                resultSet.getDate("due_date").toLocalDate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
