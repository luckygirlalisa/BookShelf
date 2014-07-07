package main.java.customServlet;

import main.java.model.Book;
import main.java.dao.BookShelfDao;
import main.java.service.BookService;
import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayServlet extends HttpServlet {
    ApplicationContext applicationContext;
    BookService bookService;

    @Override
    public void init() {
        applicationContext = (ApplicationContext)this.getServletContext().getAttribute("ioc");
        bookService = (BookService)applicationContext.getBean("book-service");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.getAllBooks();
        request.setAttribute("bookList", bookList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Books-in-cart.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
