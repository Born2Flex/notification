## Run locally

### ActiveMQ configuration

Notification Service uses ActiveMQ for messaging. You can configure the queue connection by specifying your `spring.activemq.broker-url` in `application.yaml`.
Or, if you have Docker installed, you can use the provided `docker-compose.yml` file to start the ActiveMQ container.

To start the MongoDB container using Docker, run the following command:
```bash
docker compose up
```

### Mailing configuration

Notification Service uses `spring mail` for sending emails. To configure the mail service, you need to provide the necessary SMTP 
server details in the `application.yaml` file. Properties you need to set up: `spring.mail.host`, `spring.mail.port`, 
`spring.mail.username`, `spring.mail.password`.

### Build & Start

Execute script to build and start Notification Service locally:
```bash
git clone https://github.com/Born2Flex/notification.git
cd notification
./mvnw package
java -jar target/*.jar
```

### File links
|Spring Boot Configuration | Class or Java property files                                                                         |
|--------------------------|------------------------------------------------------------------------------------------------------|
|The Main Class | [NotificationApplication](src/main/java/ua/edu/internship/notification/NotificationApplication.java) |
|Properties Files | [application.yaml](src/main/resources/application.yaml)                                              |
