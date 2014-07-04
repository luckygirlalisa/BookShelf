package main.java.customServlet;

import main.java.model.Book;
import main.java.service.BookShelfService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayServlet extends HttpServlet {
    ApplicationContext applicationContext;
    BookShelfService bookShelfService;

    @Override
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:bookshelf-beans.xml");
        bookShelfService = (BookShelfService)applicationContext.getBean("bookshelf-service");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookShelfService.fetchAllBooksFromDB();

        request.setAttribute("bookList", bookList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Books-in-cart.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
