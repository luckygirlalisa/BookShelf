package main.java.dataManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookShelfDataManager {
    public void insertBookIntoBookList(DataSource dataSource, String book_name) {
        try {
            Connection connection = dataSource.getConnection("root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into book_list(name) values('" + book_name + "');");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getBooksFromBookList(DataSource dataSource) {
        try {
            Connection connection = dataSource.getConnection("root", "");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select name from book_list");
            ArrayList<String> bookList = new ArrayList<String>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                bookList.add(name);
            }
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
