package main.java.customServlet;

import main.java.service.BookShelfService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    ClassPathXmlApplicationContext applicationContext;
    BookShelfService bookShelfService;

    @Override
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:bookshelf-beans.xml");
        bookShelfService = (BookShelfService) applicationContext.getBean("bookshelf-service");
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Book-shelf-home.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        bookShelfService.addBookToDB(request.getParameter("book_name"));
    }
}
