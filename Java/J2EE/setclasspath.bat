@echo off

set classpath=.;C:\GitHub\exercise\Java\J2EE\WEB-INF\lib\javax.servlet.jsp.jstl-1.2.1.jar;C:\GitHub\exercise\Java\J2EE\WEB-INF\lib\javax.servlet.jsp.jstl-api-1.2.1.jar;C:\GitHub\exercise\Java\J2EE\WEB-INF\lib\jsp-api.jar;C:\GitHub\exercise\Java\J2EE\WEB-INF\lib\servlet-api.jar

@echo on
javac -encoding utf-8 factory/*.java -d ../classes
