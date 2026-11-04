package controllers.returnBooks;

import controllers.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ReturnBookDTO;

import java.sql.*;
import java.time.LocalDate;

public class ReturnBookController {
    Connection connection = DBConnection.getInstance().getConnection();

    public boolean returnBooks(ReturnBookDTO returnBookDTO) {
        String SQL = "INSERT INTO returned_books(book_id,member_id,phone_number,address,borrowed_date,due_date,returned_date) VALUES(?, ?, ?, ?, ?, ?, ?) ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,returnBookDTO.getCmbBookId());
            preparedStatement.setInt(2,returnBookDTO.getCmbMemberId());
            preparedStatement.setString(3,returnBookDTO.getPhoneNumber());
            preparedStatement.setString(4,returnBookDTO.getAddress());
            preparedStatement.setDate(5, Date.valueOf(returnBookDTO.getBorrowedDate()));
            preparedStatement.setDate(6, Date.valueOf(returnBookDTO.getDueDate()));
            preparedStatement.setDate(7, Date.valueOf(returnBookDTO.getReturnedDate()));

            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    public void loadBorrowList(int book_id, ReturnBookPageController returnBookPageController){
        String SQL = """
                SELECT 
                    m.member_id,
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
            returnBookPageController.fillBorrowingDetails(
                    resultSet.getInt("member_id"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getDate("issue_date").toLocalDate(),
                    resultSet.getDate("due_date").toLocalDate()

            );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
