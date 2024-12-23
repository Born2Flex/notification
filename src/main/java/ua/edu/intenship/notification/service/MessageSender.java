package ua.edu.intenship.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ua.edu.intenship.notification.service.message.user.BaseUserMessage;

@Service
@RequiredArgsConstructor
public class MessageSender {
    private final JmsTemplate jmsTemplate;

    public void sendUserCreatedMessage(BaseUserMessage message) {
        jmsTemplate.convertAndSend("user.queue", message);
    }
}
