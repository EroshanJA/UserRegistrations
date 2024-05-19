# Read Me First

# Description about the application
This applicaion has provided APIs to register new users of electric system.

# Required configuations
JAVA 17 
SpringBoot 3.2.5

# How to Build the application
To build the application => mvn clean install 
To run the application   => mvn spring-boot:run
To run unit testing      => mvn clean test

# API endpoints
get users by Id       => GET - http://localhost:8080/api/users/{id}
get users by LastName => GET - http://localhost:8080/api/users/search?lastName={last name}
registor new user     => 
        POST http://localhost:8080/api/users 
        Payload : { "firstName" : "", "lastName" : "", "email" : ""}

# How to refer API documentation
API Documentation => http://localhost:8080/swagger-ui/

# How to access the db
DB URL      => http://localhost:8080/userdb-ui
DB Name     => UserRegistrations
User Name   => admin
Password    => admin!23
