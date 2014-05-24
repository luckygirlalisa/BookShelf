package main.java;

import main.java.dataManager.BookShelfDataManager;

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

        System.out.println(servletContext.getAttribute("mySqlDataSource"));
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
