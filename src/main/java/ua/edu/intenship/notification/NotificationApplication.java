package ua.edu.intenship.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.edu.intenship.notification.service.MessageSender;
import ua.edu.intenship.notification.service.message.user.UserCreatedUserMessage;
import ua.edu.intenship.notification.service.message.user.UserDeletedUserMessage;

@SpringBootApplication
public class NotificationApplication {

    public static void main(String[] args) {
        var app = SpringApplication.run(NotificationApplication.class, args);
        MessageSender sender = app.getBean(MessageSender.class);
        sender.sendUserCreatedMessage(new UserCreatedUserMessage("email@gmail.com"));
        sender.sendUserCreatedMessage(new UserDeletedUserMessage("email@gmail.com"));
    }

}
