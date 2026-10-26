package mainDashboard;

import controllers.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DashboardController {
            Connection connection = DBConnection.getInstance().getConnection();
    public ObservableList<Map<String, String>> loadDetails() {
        ObservableList <Map<String,String>> dashboardDetails = FXCollections.observableArrayList();
        String SQL = """
                SELECT i.book_id,b.book_title,
                m.full_name,i.issue_date,
                i.due_date
                FROM issue_book 
                INNER JOIN members ON 
                i.member_id = m.meber_id
                INNER JOIN books ON
                i.book_id = b.book_id
                ORDER BY issue_date DESC
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Map<String,String> row = new HashMap<>();
                row.put("book_id",String.valueOf(resultSet.getInt("book_id")) != null ? String.valueOf(resultSet.getInt("member_id")) : "");
                row.put("book_title",resultSet.getString("book_title") != null ? resultSet.getString("book_title") : "");
                row.put("full_name",resultSet.getString("full_name") != null ? resultSet.getString("full_name") : "");
                row.put("issue_date",resultSet.getString("issue_date") != null ? resultSet.getString("issue_date") : "");
                row.put("due_date",resultSet.getString("due_date") != null ? resultSet.getString("due_date") : "");
                dashboardDetails.add(row);


            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loadDetails();

    }
}

