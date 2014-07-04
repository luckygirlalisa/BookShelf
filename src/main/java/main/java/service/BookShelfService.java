package main.java.service;

import main.java.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookShelfService {
    private JdbcTemplate jdbcTemplate;

    public BookShelfService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBookToDB(String bookName) {
        jdbcTemplate.execute("insert into book_list(name) values('" + bookName + "');");
    }

    public List<Book> fetchAllBooksFromDB() {
        List<Map> searchResult = jdbcTemplate.queryForList("select * from book_list");
        List<Book> books = new ArrayList<Book>();

        for(Map result : searchResult) {
            Book book = new Book();
            book.setISBN((Integer) result.get("ISBN"));
            book.setName((String) result.get("name"));
            books.add(book);
        }

        return books;
    }
}
