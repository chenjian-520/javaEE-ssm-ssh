package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyApplicationListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("applicationÏú»Ù");
    }


    public void contextInitialized(ServletContextEvent ev)  { 
    	Map<String, Integer> map = new HashMap<>();
        ev.getServletContext().setAttribute("map", map);
    }
	
}
