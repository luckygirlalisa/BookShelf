package main.java;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookShelfDataSource {
    private MysqlDataSource mysqlDataSource;

    public BookShelfDataSource() {
        mysqlDataSource = getMySqlDataSource();
    }

    public void manageDB(String book_name) {
        try {
            Connection connection = mysqlDataSource.getConnection("root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into book_list(name) values('" + book_name + "');");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private MysqlDataSource getMySqlDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/book_shelf");
        return mysqlDataSource;
    }
}
