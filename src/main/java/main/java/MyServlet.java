package main.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/Book-shelf-home.jsp");
        requestDispatcher.forward(request, response);

//        new DBConnection().manageDB(request.getParameter("book_name"));
        new DataSourceConnection().manageDB(request.getParameter("book_name"));
    }
}
