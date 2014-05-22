package main.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private BookShelfServletContext servletContext;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Book-shelf-home.jsp");
        requestDispatcher.forward(request, response);

        String contextPath = request.getContextPath();
        servletContext = new BookShelfServletContext(contextPath);
        servletContext.addServlet(this);

        servletContext.getBookShelfDataSource().manageDB(request.getParameter("book_name"));
    }
}
