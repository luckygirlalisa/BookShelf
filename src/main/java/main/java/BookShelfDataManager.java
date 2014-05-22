package main.java;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookShelfDataManager {
    public void manageDB(DataSource dataSource, String book_name) {
        try {
            Connection connection = dataSource.getConnection("root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into book_list(name) values('" + book_name + "');");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
