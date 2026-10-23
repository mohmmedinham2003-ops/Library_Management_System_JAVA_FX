package controllers.borrowingHistory;

import controllers.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BorrowingHistoryController {
    Connection connection = DBConnection.getInstance().getConnection();

    public ObservableList<Map<String,String>> getHistoryTable() {
        ObservableList<Map<String, String>> borrowList = FXCollections.observableArrayList();
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = """
        SELECT
            m.member_id,
            b.book_title,
            i.issue_date,
            i.due_date,
            r.returned_date
        FROM issue_book i
        JOIN members m
            ON i.member_id = m.member_id
        JOIN books b
            ON i.book_id = b.book_id
        LEFT JOIN returned_books r
            ON r.member_id = i.member_id
            AND r.book_id = i.book_id
        ORDER BY i.issue_date ASC
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Map<String, String> row = new HashMap<>();
                row.put("member_id",resultSet.getString("member_id") != null ? resultSet.getString("member_id") : "");
                row.put("book_title", resultSet.getString("book_title") != null ? resultSet.getString("book_title") : "");
                row.put("issue_date", resultSet.getString("issue_date") != null ? resultSet.getString("issue_date") : "");
                row.put("due_date", resultSet.getString("due_date") != null ? resultSet.getString("due_date") : "");
                row.put("returned_date", resultSet.getString("returned_date") != null ? resultSet.getString("returned_date") : "");

                borrowList.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return borrowList;
    }
}
