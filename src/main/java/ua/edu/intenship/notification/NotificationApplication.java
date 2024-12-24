package ua.edu.intenship.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.edu.intenship.notification.service.message.user.UserCreatedUserMessage;

@SpringBootApplication
public class NotificationApplication {

    public static void main(String[] args) {
        var app = SpringApplication.run(NotificationApplication.class, args);
        MessageSender sender = app.getBean(MessageSender.class);
        sender.sendUserCreatedMessage(new UserCreatedUserMessage("geografy2314@gmail.com", "Danylo"));
//        sender.sendUserCreatedMessage(new UserDeletedUserMessage("email@gmail.com", ""));
//        sender.send("geografy2314@gmail.com", "Hello!", "Hello, it's first message send by your Spring application");
    }

}
