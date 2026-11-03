package controllers.books;

import controllers.db.DBConnection;
import model.BookDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBookController {


    public boolean addBook(BookDTO bookDTO) {
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO books(book_title,author,category,published_year,quantity) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,bookDTO.getBookTitle());
            preparedStatement.setString(2,bookDTO.getAuthor());
            preparedStatement.setString(3,bookDTO.getCategory());
            preparedStatement.setInt(4,bookDTO.getPublishedyear());
            preparedStatement.setInt(5,bookDTO.getQuantity());

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
