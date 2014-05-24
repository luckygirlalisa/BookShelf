package main.java;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class DisplayServlet extends HttpServlet {
    private ServletContext servletContext;
    BookShelfDataManager bookShelfDataManager = new BookShelfDataManager();

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();

        MysqlDataSource mySqlDataSource = new MysqlDataSource();
        mySqlDataSource.setURL("jdbc:mysql://localhost:3306/book_shelf");
        servletContext.setAttribute("mySqlDataSource", mySqlDataSource);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> bookNameList = bookShelfDataManager.getBooksFromBookList((DataSource) servletContext.getAttribute("mySqlDataSource"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Books-in-cart.jsp");

            request.setAttribute("bookNames", bookNameList);

        requestDispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
