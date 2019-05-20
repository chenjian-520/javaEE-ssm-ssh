package litener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyAppactionLitener
 *
 */
@WebListener
public class MyAppactionLitener implements ServletContextListener {
    /**
     * Default constructor. 
     */
    public MyAppactionLitener() {
        // TODO Auto-generated constructor stub
    }
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	 System.out.println("aplication销毁");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent ev)  { 
         // TODO Auto-generated method stub
    	System.out.println("application创建初始化");
    	Map<String,String> arg1 = new HashMap<>();
    	ev.getServletContext().setAttribute("map", arg1);
    }
	
}
