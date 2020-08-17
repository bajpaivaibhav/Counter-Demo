# Counter Upadation
Incrementing counter in database on each hit to the endpoint mentioned below.

# Tools Used
* JAVA8
* Springboot
* Maven
* SpringMVC
* JPA/Hibernate
* Lombok
* MySql

# For DataBase
Mysql database is used so change the following fields in application.properties  
* spring.datasource.url = jdbc:mysql://localhost:3306/org?useSSL=false
* spring.datasource.username = root
* spring.datasource.password = 	

# How to run the application  
A table Counter will be created at the time of application startup with initial count of 0.  
Query for initial insertion is put in data.sql  
Run war file on any server tomcat preferable.  
endpoint = performancetester/counter  

or can use springtestsuit to run the application
