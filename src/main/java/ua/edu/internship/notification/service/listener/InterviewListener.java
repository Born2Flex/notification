package ua.edu.internship.notification.service.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ua.edu.internship.notification.service.business.MailService;
import ua.edu.internship.notification.service.message.interview.InterviewScheduledMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class InterviewListener {
    private final MailService mailService;

    @JmsListener(destination = "${interview.queue}")
    public void processInterviewMessage(InterviewScheduledMessage message) {
        log.info("Received new interview message: {}", message);
        mailService.sendInterviewNotification(message);
    }
}
