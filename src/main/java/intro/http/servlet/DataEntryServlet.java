package intro.http.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class DataEntryServlet
 */
@WebServlet(urlPatterns= {"/"})
public class DataEntryServlet extends HttpServlet {

    private static final long serialVersionUID = -8841393714298790424L;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        logger.info("ENTER service(request,response)");
        

    //    request.getRequestDispatcher("/WEB-INF/jsp/one.jsp").include(request, response);
        request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);

        logger.info("EXIT service(request,response)");
    }

}
