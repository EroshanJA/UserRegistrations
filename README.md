# User Registrations API

### Description about the application
This applicaion has provided APIs to register new users of electric system.

###  Required configuations
JAVA 17<br>
SpringBoot 3.2.5

###  How to Build the application
To build the application => mvn clean install <br>
To run the application&nbsp;&nbsp;   => mvn spring-boot:run <br>
To run unit testing&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      => mvn clean test <br>

###  API endpoints
get users by Id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       => GET - http://localhost:8080/api/users/{id}<br>
get users by LastName => GET - http://localhost:8080/api/users/search?lastName={last name}<br>
registor new user&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     => <br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;POST http://localhost:8080/api/users <br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Payload : { "firstName" : "", "lastName" : "", "email" : ""}

###  How to refer API documentation
API Documentation => http://localhost:8080/swagger-ui/

###  How to access the db
DB URL&emsp;&emsp;      => http://localhost:8080/userdb-ui<br>
DB Name&emsp;     => UserRegistrations<br>
User Name&nbsp;   => admin<br>
Password&emsp;    => admin!23<br>
