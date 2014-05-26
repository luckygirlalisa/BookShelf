package main.java.customServlet;

import main.java.dataManager.BookShelfDataManager;
import main.java.dataManager.BookshelfDataSource;
import main.java.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class DisplayServlet extends HttpServlet {
    private ServletContext servletContext;
    BookShelfDataManager bookShelfDataManager = new BookShelfDataManager();

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource bookshelfDataSource = ((BookshelfDataSource) servletContext.getAttribute("mySqlDataSource")).getMysqlDataSource();
        List<Book> bookList = bookShelfDataManager.getBooksFromBookList(bookshelfDataSource);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Books-in-cart.jsp");

        request.setAttribute("bookList", bookList);

        requestDispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
