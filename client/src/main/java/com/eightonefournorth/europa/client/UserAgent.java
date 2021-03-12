package com.eightonefournorth.europa.client;

import java.sql.*;

public class UserAgent {

	public UserAgent() {
	}

	public UserAgentItem parseUserAgent(String userAgent) throws Exception {
		UserAgentItem uai = new UserAgentItem();
		String browserName = "unknown";
		String browserVer = "unknown";
		if (userAgent.contains("Chrome")) { // checking if Chrome
			String substring = userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0];
			browserName = substring.split("/")[0];
			browserVer = substring.split("/")[1];
		} else if (userAgent.contains("Firefox")) { // Checking if Firefox
			String substring = userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0];
			browserName = substring.split("/")[0];
			browserVer = substring.split("/")[1];
		} else if (userAgent.contains("MSIE")) { // Checking if Internet Explorer
			String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
			browserName = substring.split(" ")[0];
			browserVer = substring.split(" ")[1];
		} else if (userAgent.contains("rv")) { // checking if Internet Explorer 11
			String substring = userAgent.substring(userAgent.indexOf("rv"), userAgent.indexOf(")"));
			browserName = "IE";
			browserVer = substring.split(":")[1];
		}
		uai.setBrowserName(browserName);
		uai.setBrowserVer(browserVer);
		uai.setClientOS(fetchClientOS(userAgent));
		System.out.println(uai);

		saveData(uai);
		return uai;
	}

	private void saveData(UserAgentItem uai){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
                // db parameters
                	String url       = "jdbc:mysql://europadb:3306/europa";
                	String user      = "europa";
                	String password  = "silverlining";
                	conn = DriverManager.getConnection(url, user, password);
                	System.out.println("Connection is Open: [" + !conn.isClosed() + "]");

			pstmt = conn.prepareStatement("insert into response(hash,browser_version,browser_name,platform) values(?,?,?,?)");

			pstmt.setString(1,"AAAAABBBBBCCCCCDDDDDEEEEEFFFFF");
			pstmt.setString(2, uai.getBrowserVer());
			pstmt.setString(3, uai.getBrowserName());
			pstmt.setString(4, uai.getClientOS());

			pstmt.executeUpdate();
			
			System.out.println("Insert pushed ... ");




		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
	               		if (conn != null) conn.close();
			}catch(Exception ex){}
		}
	}

	private String fetchClientOS(String au) {
		String lowerCaseBrowser = au.toLowerCase();
		if (lowerCaseBrowser.contains("windows")) {
			return "Windows";
		} else if (lowerCaseBrowser.contains("mac")) {
			return "Mac";
		} else if (lowerCaseBrowser.contains("x11")) {
			return "Unix";
		} else if (lowerCaseBrowser.contains("android")) {
			return "Android";
		} else if (lowerCaseBrowser.contains("iphone")) {
			return "IPhone";
		} else {
			return "UnKnown, More-Info: " + au;
		}
	}

	public static void main(String[] args) {
		try {
			new UserAgent().parseUserAgent(
					"User-agent header: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:86.0) Gecko/20100101 Firefox/86.0");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
