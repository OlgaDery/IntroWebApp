/**
 * 
 */
package intro.restful;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import intro.ejb.SingletonEJB;

/**
 * @author Olga
 *
 */
@RequestScoped
@Path("/")
@Produces({"application/json" })
//@Consumes({ "application/xml", "application/json" })

public class Username 

{
	private static final Logger LOG = LoggerFactory.getLogger(Username.class);
	
	@EJB
	SingletonEJB ejb;
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/")
	   public JSONArray publishNames()//@PathParam("name") String name) 
	{
		LOG.info("enter publishNames");
		
		
		JSONArray lst = new JSONArray();
		
		for (String name : ejb.getUsers()) 
		{
			JSONObject js_obj = new JSONObject();
			js_obj.put("name", name);
			lst.add(js_obj);
		}
	//	PrintWriter out;
		
		try {
	//		response.setContentType("application/json");
	//		out = response.getWriter();
			return lst;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			LOG.info("exit publishNames");
		}
		
	      // search my database and get a string representation and return it
	 }
	
	 @POST
	 	@Path("/{name}")
	 	public void getUser(@PathParam("name") String name) 
	 {
		 LOG.info("enter getUser(String name) ");
		 
		 LOG.info("name : {}", name);
		 ejb.addUser(name);
		 LOG.info("exit getUser(String name) ");
		 
	 };

}



