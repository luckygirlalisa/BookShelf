package main.java.dataManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BookShelfDBConnection {
    public void manageDB(String book_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shelf", "root", "");
            Statement statement = connection.createStatement();

            String insertBook = "insert into book_list(name) values('" + book_name + "');";
            statement.executeUpdate(insertBook);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}