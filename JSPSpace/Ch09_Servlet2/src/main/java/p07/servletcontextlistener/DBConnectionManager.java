package p07.servletcontextlistener;

import java.sql.Connection;

public class DBConnectionManager {
	private String dbURL;
	private String user;
	private String password;
	private Connection con;
	
	public DBConnectionManager(String url, String user, String pw) {
		this.dbURL = url;
		this.user = user;
		this.password = pw;
	}
	
	public Connection getConnection() {
		return this.con;
	}
	
	public void closeConnection() {
		//close DB connection here
	}
}
