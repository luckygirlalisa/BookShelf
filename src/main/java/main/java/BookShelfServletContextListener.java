package main.java;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BookShelfServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        MysqlDataSource mySqlDataSource = new MysqlDataSource();
        mySqlDataSource.setURL("jdbc:mysql://localhost:3306/book_shelf");
        servletContext.setAttribute("mySqlDataSource", mySqlDataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
