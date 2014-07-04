package main.java.customServlet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import main.java.dataManager.BookShelfDataManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    BookShelfDataManager bookShelfDataManager;
    ClassPathXmlApplicationContext applicationContext;
    DataSource bookShelfDataSource;

    @Override
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:bookshelf-beans.xml");
        bookShelfDataManager = (BookShelfDataManager)applicationContext.getBean("bookshelf-data-manager");
        bookShelfDataSource = (MysqlDataSource)applicationContext.getBean("mysql-data-source");
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
        bookShelfDataManager.insertBookIntoBookList(bookShelfDataSource, request.getParameter("book_name"));
    }
}
