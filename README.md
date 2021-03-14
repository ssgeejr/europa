# europa-
Java Phishing Client/Server application based on a docker foundation 


### Code example for browser version checking

```
<div id="example"></div>

<script type="text/javascript">

txt = "<p>Browser CodeName: " + navigator.appCodeName + "</p>";
txt+= "<p>Browser Name: " + navigator.appName + "</p>";
txt+= "<p>Browser Version: " + navigator.appVersion + "</p>";
txt+= "<p>Cookies Enabled: " + navigator.cookieEnabled + "</p>";
txt+= "<p>Platform: " + navigator.platform + "</p>";
txt+= "<p>User-agent header: " + navigator.userAgent + "</p>";

document.getElementById("example").innerHTML=txt;

</script>
```


### References

https://www.seanmcp.com/articles/how-to-get-the-browser-version-in-javascript/


For the unnaturally long startup time with tomcat: 


4

Found the answer and it worked...

https://stackoverflow.com/a/26432537/450586

Basically...

Go to the JDK/security folder and edit java.security

in my case: /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/security/java.security

Change

securerandom.source=file:/dev/random

to

securerandom.source=file:/dev/./urandom



## MYSQL

select timezone: 

`SELECT @@GLOBAL.time_zone, @@SESSION.time_zone;`


