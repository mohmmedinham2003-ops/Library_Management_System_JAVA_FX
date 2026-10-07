package controllers.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/?", "root",
                    "123456789"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}