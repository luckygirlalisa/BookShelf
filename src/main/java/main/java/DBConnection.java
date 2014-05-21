package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shelf", "root", "");
            Statement statement = connection.createStatement();

            String insertBook = "insert into book_list values(0001, '" + args[0] + "');";
            statement.executeUpdate(insertBook);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
