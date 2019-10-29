1. #### **General description**
	The project includes backend of an online store.
2. #### **Demo**
	Some screenshots demonstrating how the application works are in the file called Demo.
3. #### **Requirements before running**
	- The application has been created using Java 8, Gradle, MySql and H2 databases, Spring and Hibernate frameworks, runs on the embedded Tomcat server. The detailed information is included in build.gradle.
	- Before running the application make sure you have the appropriate software installed. Credentials for the databases are listed in application.properties file. Remember to change the credentials in case you use other username, password, project name, also check the server timezone. When running the application make sure that your database is closed or uses different port.
	- The application includes a service of sending notifications to the admin email address when a new order has been created. By default the database is checked every 30 minutes, you can change the frequency in the EmailScheduler class. Make sure to set these fields of the application.property file before running: spring.mail.username and spring.mail.password are login and password of the email sender, admin.mail is a receiver of the email.
4. #### **Running the application**
	Before running the application build it using 'gradlew build' command in the terminal of your IDE. To start the application run a file called EcommerceeApplication situated in the package 'com.kodilla.ecommercee'.
5. #### **Endpoints**
    After running the application go to http://localhost:8080/swagger-ui.html for API documentation and comprehensive description of the endpoints.
6. 	#### **Utilization**
      The application is used to create and handle a database of an online store. It enables creation of products and product groups, users and their carts, allows making orders and track payments. The application may be developed to a holistic online store webpage by adding a frontend part.
