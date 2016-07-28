package intro.http.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class AppStartup
 *
 */
@WebListener
public class AppStartup implements ServletContextListener {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.trace("ENTER contextDestroyed(sce)");
        log.trace("EXIT contextDestroyed(sce)");
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.trace("ENTER contextContextinitialized(sce)");

        setupWebPages(sce);

        log.trace("EXIT contextContextInitialized(sce)");
    }

    /**
     * Configures all the webpages that are to be used by the application
     *
     * @param sce
     */
    private void setupWebPages(ServletContextEvent sce) {
        log.trace("ENTER setupWebPages(sce)");

        log.trace("ENTER setupWebPages(sce)");
    }

    /**
     * Reads from a configuration and setups supported locales for the web
     * application
     * 
     * @param sce
     */
   
}
