package ua.edu.intenship.notification.service.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ua.edu.intenship.notification.service.business.MailService;
import ua.edu.intenship.notification.service.message.interview.InterviewScheduledMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class InterviewListener {
    private final MailService mailService;

    @JmsListener(destination = "interview.queue")
    public void processUserEvent(InterviewScheduledMessage message) {
        log.info("Received new interview message: {}", message);
        mailService.sendInterviewNotification(message);
    }
}
