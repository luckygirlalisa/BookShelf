package main.java;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceConnection {
    public void manageDB(String book_name) {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/book_shelf");
        try {
            Connection connection = mysqlDataSource.getConnection("root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into book_list(name) values('" + book_name + "');");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
