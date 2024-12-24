package ua.edu.intenship.notification.service.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ua.edu.intenship.notification.service.business.MailService;
import ua.edu.intenship.notification.service.message.user.BaseUserMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserListener {
    private final MailService mailService;

    @JmsListener(destination = "user.queue")
    public void processUserMessage(BaseUserMessage message) {
        log.info("Received new user message: {}", message);
        mailService.sendUserNotification(message);
    }
}
