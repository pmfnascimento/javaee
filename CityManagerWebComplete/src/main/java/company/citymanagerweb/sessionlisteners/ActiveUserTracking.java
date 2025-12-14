package company.citymanagerweb.sessionlisteners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ActiveUserTracking
 *
 */
@WebListener
public class ActiveUserTracking implements HttpSessionListener {
	private static int activeUsers;
    /**
     * Default constructor. 
     */
    public ActiveUserTracking() {
    	
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent hse) {
    	System.out.println("A new Session was created");
    	activeUsers++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent hse) {
    	System.out.println("An existing Session was destroyed");
    	activeUsers--;
    }
	
    public static int getActiveUserCount()
    {
    	return activeUsers;
    }
}
