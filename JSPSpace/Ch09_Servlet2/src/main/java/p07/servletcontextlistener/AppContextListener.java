package p07.servletcontextlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

	public AppContextListener() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * spring은 tomcat server가 메모리에 올라가면서
	 * spring app(container)을 메모리에 올리고(ServletContextListener을 사용)
	 * spring web application을 메모리에 올림
	 */
	// tomcat server가 web application을 초기에 메모리에 올릴 떄 한 번 실행
	// DB관련 library에 대한 simulation한 코딩
	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext ctx = sce.getServletContext(); // ctx == application
		
		String url = ctx.getInitParameter("DBURL");
		String user = ctx.getInitParameter("DBUSER");
		String password = ctx.getInitParameter("DBPWD");
		
		// create database connection from init parameters and set it to context
		DBConnectionManager dbManager = new DBConnectionManager(url, user, password);
		ctx.setAttribute("DBManager", dbManager);
		System.out.println("Database connection initialized for Application");
	}
	
	// tomcat server가 종료되기 직전에 실행되는 메소드
    public void contextDestroyed(ServletContextEvent sce)  { 
    	ServletContext ctx = sce.getServletContext();
    	DBConnectionManager dbManager = (DBConnectionManager)ctx.getAttribute("DBManager");
    	dbManager.closeConnection();
    	System.out.println("Database connection closed Application");
    }

	
}
