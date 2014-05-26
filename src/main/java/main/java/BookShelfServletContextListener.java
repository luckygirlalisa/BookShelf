package main.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BookShelfServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:bookshelf-beans.xml");
        Object bookshelfDataSource = applicationContext.getBean("bookshelf-data-source");
        servletContext.setAttribute("mySqlDataSource", bookshelfDataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
