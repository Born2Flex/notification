package ua.edu.intenship.notification.service.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ua.edu.intenship.notification.service.message.interview.BaseInterviewMessage;

@Component
public class InterviewListener {

    @JmsListener(destination = "interview.queue")
    public void processUserEvent(BaseInterviewMessage userEvent) {
        System.out.println(userEvent.getMessageType().getEmailTemplate());
    }
}
