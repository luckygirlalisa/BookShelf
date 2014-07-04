package main.java.customServlet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import main.java.dataManager.BookShelfDataManager;
import main.java.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class DisplayServlet extends HttpServlet {
    BookShelfDataManager bookShelfDataManager;
    ApplicationContext applicationContext;
    DataSource bookShelfDataSource;

    @Override
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:bookshelf-beans.xml");
        bookShelfDataManager = (BookShelfDataManager)applicationContext.getBean("bookshelf-data-manager");
        bookShelfDataSource = (MysqlDataSource)applicationContext.getBean("mysql-data-source");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookShelfDataManager.getBooksFromBookList(bookShelfDataSource);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Books-in-cart.jsp");

        request.setAttribute("bookList", bookList);

        requestDispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
