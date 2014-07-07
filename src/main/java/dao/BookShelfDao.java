package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class BookShelfDao {
    private JdbcTemplate jdbcTemplate;

    public BookShelfDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBookToDB(String bookName) {
        jdbcTemplate.execute("insert into book_list(name) values('" + bookName + "');");
    }

    public List<Map> fetchAllBooksFromDB() {
        return jdbcTemplate.queryForList("select * from book_list");
    }
}
