package com.eightonefournorth.europa.client;

public class UserAgent {

	public UserAgent() {
		try {
			parseUserAgent("User-agent header: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:86.0) Gecko/20100101 Firefox/86.0");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void parseUserAgent(String userAgent) throws Exception{
        String browserName="unknown";
        String browserVer="unknown";
        if(userAgent.contains("Chrome")){ //checking if Chrome
            String substring=userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0];
            browserName=substring.split("/")[0];
            browserVer=substring.split("/")[1];
        }else if(userAgent.contains("Firefox")){  //Checking if Firefox
            String substring=userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0];
            browserName=substring.split("/")[0];
            browserVer=substring.split("/")[1];
        }else if(userAgent.contains("MSIE")){ //Checking if Internet Explorer
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browserName=substring.split(" ")[0];
            browserVer=substring.split(" ")[1];
        }else if(userAgent.contains("rv")){ //checking if Internet Explorer 11
		     String substring=userAgent.substring(userAgent.indexOf("rv"),userAgent.indexOf(")"));
		     browserName="IE";
		     browserVer=substring.split(":")[1];	
	     }

     System.out.println("browserName: " + browserName );  
     System.out.println("browserVer: " + browserVer );
     System.out.println("OS: " + fetchClientOS(userAgent) );
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
		new UserAgent();

	}

}
