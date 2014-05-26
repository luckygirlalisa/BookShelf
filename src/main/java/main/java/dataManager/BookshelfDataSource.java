package main.java.dataManager;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class BookshelfDataSource {
    private MysqlDataSource mysqlDataSource;

    public BookshelfDataSource() {
        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/book_shelf");
    }

    public MysqlDataSource getMysqlDataSource() {
        return mysqlDataSource;
    }
}
