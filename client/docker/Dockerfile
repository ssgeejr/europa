FROM europacat
RUN rm -rf /usr/local/tomcat/webapps/*
ADD https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.15/mysql-connector-java-8.0.15.jar /usr/local/tomcat/lib/
COPY europa.war /usr/local/tomcat/webapps/ROOT.war
