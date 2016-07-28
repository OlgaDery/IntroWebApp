/**
 * 
 */
package intro.ejb;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Olga
 *
 */
@Singleton
@LocalBean
@Startup
public class SingletonEJB 
{
	
		private final Logger logger = LoggerFactory.getLogger(getClass());
		
		//this map gets initialized on the startup of the app, later the content of it may be modified 
	    private List<String> users;
	    
	    @PostConstruct
	    private void postConstruct() 
	    {
	    	
	    	logger.info("enter postConstruct()");
	    	
	    	users = new LinkedList <String>();
	    	
	    	logger.info("exit postConstruct()");
	    }
	    
	    public void addUser (String userName) 
	    {
	    	logger.info("enter addUser (String userName)");
	    	users.add(userName);
	    	
	    	logger.info("user list size: {}", users.size());
	    	
	    	logger.info("exit addUser (String userName)");
	    }
	    
	    public List <String> getUsers() 
	    {
	    	logger.info("enter getUsers()");
	    	
	    	logger.info("user list size: {}", users.size());
	    	
	    	logger.info("exit getUsers() ");
			return users;
	    	
	    }
	    
	   

}
