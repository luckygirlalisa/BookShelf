package service;

import dao.BookShelfDao;
import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService {
    private BookShelfDao bookShelfDao;

    public BookService(BookShelfDao bookShelfDao) {
        this.bookShelfDao = bookShelfDao;
    }

    public void addBook(String bookName) {
        bookShelfDao.addBookToDB(bookName);
    }

    public List<Book> getAllBooks() {
        List<Map> searchResult = bookShelfDao.fetchAllBooksFromDB();
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
