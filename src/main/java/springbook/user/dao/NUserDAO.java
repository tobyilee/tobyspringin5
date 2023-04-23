package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NUserDAO extends UserDAO{
    @Override
    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "spring", "book");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
