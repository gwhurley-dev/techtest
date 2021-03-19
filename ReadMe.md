## Block.one Tech Test

This is the deliverable for the Block.one Tech Test for a Lead Java Engineer position.

Geoff Hurley - gwhurley.dev@gmail.com

### Architecture

- Automated CI/CD Pipeline on AWS Cloud Formations.
- Jenkins EC2 instance builds automatically upon Github commit.
- Successful builds deployed to a customized Amazon Linux 2 EC2 image.
- Auto Scaling launches EC2 instances as needed which join the Load Balancer group.
- MySql database on EC2.

### Usage

See /scripts/postman_collection.json<br>
Postman will need the following variables defined:
- url: blockone.softwarehammer.com (AWS Load Balancer URL)
- port: 80

### Libraries Used
- Spring Boot
- Maven
- MyBatis
- Lombok
- MySql

### Local Build
```
mvn compile
mvn package
java -jar target/techtest-0.0.1-SNAPSHOT.jar
```

### Additional Notes
- I had to make a few assumptions about the requirements.
- Security groups are in place but I've left it open to 0.0.0.0/0 for testing.
- Currently no unit tests.  I just have too much to do at the moment, but I'm very experienced with JUnit, Mockito, EasyMock, Gherkin, Cucumber, Specflow, Selenium, Selenium Web Driver, etc, as well as unit testing in .NET and NodeJS.
- The requirements state that nothing can be deleted, but one of the example API calls was a delete.  So I went ahead and created delete endpoints.
