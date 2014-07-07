package listener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BookShelfServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:bookshelf-beans.xml");
        sce.getServletContext().setAttribute("ioc", classPathXmlApplicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
