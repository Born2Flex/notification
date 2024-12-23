package ua.edu.intenship.notification.service.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ua.edu.intenship.notification.service.message.user.BaseUserMessage;

@Component
public class UserListener {

    @JmsListener(destination = "user.queue")
    public void processUserEvent(BaseUserMessage userEvent) {
        System.out.println(userEvent.getMessageType().getEmailTemplate());
    }

}
