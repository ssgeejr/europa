<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Europa Phishing Client</title>
</head>
<body>

<%= new java.util.Date().toString() %>
<%= request.getHeader("User-Agent") %>

<hr>

<%@ page import="com.eightonefournorth.europa.client.*" %>

<%

String hash = request.getParameter("hid");

System.out.println("HASH: " + hash);

if (hash == null || hash.length() != 32) return; 

UserAgentItem uai = new UserAgent().parseUserAgent(request.getHeader("User-Agent"));
String bv = ""; 
String bn = ""; 
String cos = ""; 

bv = uai.getBrowserVer();
bn = uai.getBrowserName();
cos = uai.getClientOS();


%>
<ul>
	<li>Browser Name: <%= bn %></li>
	<li>Browser Version: <%= bv %></li>
	<li>Client OS: <%= cos %></li>
</ul>
</body>
</html>
