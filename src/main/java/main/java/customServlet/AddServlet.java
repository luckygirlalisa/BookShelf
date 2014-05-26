package main.java.customServlet;

import main.java.dataManager.BookShelfDataManager;
import main.java.dataManager.BookshelfDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private ServletContext servletContext;
    BookShelfDataManager bookShelfDataManager = new BookShelfDataManager();

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/pages/Book-shelf-home.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        DataSource bookshelfDataSource = ((BookshelfDataSource) servletContext.getAttribute("mySqlDataSource")).getMysqlDataSource();
        bookShelfDataManager.insertBookIntoBookList(bookshelfDataSource, request.getParameter("book_name"));
    }
}
