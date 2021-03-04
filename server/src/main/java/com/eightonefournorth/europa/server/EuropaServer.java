package com.eightonefournorth.europa.server;

import java.sql.*;

public class EuropaServer{

public EuropaServer(){
	try{
		System.out.println("LOOK AT ME GO!!!!");
		openConnection();
	}catch(Exception ex){
		ex.printStackTrace();
	}
}

private void openConnection() throws Exception{
Connection conn = null;
	try {
    		// db parameters
    		String url       = "jdbc:mysql://europadb:3306/europa";
    		String user      = "europa";
    		String password  = "silverlining";
    		conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connection is Open: [" + !conn.isClosed() + "]");
	} finally {
		if (conn != null) conn.close();
	}
}

public static void main(String args[]){
	new EuropaServer();
}
}
