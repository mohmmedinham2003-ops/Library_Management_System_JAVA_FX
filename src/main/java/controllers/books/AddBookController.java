package controllers.books;

import controllers.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBookController {
    public boolean addbook(String book_title, String author, String category, int published_year, int quantity) {
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO books(book_title,author,category,published_year,quantity) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,book_title);
            preparedStatement.setString(2,author);
            preparedStatement.setString(3,category);
            preparedStatement.setInt(4,published_year);
            preparedStatement.setInt(5,quantity);

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
