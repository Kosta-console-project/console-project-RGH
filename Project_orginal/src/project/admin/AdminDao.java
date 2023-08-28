package project.admin;

import project.config.DBConnect;

public class AdminDao {
	private DBConnect dbconn;
	
	public AdminDao() {
		dbconn=DBConnect.getInstance();
	}
	
	
}
