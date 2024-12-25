package ua.edu.internship.notification.service.listener;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.edu.internship.notification.service.business.MailService;
import ua.edu.internship.notification.service.enumeration.MessageType;
import ua.edu.internship.notification.service.message.interview.InterviewScheduledMessage;
import java.time.LocalDateTime;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InterviewListenerTest {
    @Mock
    private MailService mailService;
    @InjectMocks
    private InterviewListener underTest;

    @Test
    @DisplayName("Should send notification via mail service when receive message")
    void shouldSendNotificationWhenReceiveMessage() {
        // given
        InterviewScheduledMessage message = new InterviewScheduledMessage("test1@gmail.com",
                "test2@gmail.com", MessageType.INTERVIEW_SCHEDULED, LocalDateTime.now());

        // when
        underTest.processInterviewMessage(message);

        // then
        verify(mailService).sendInterviewNotification(message);
    }
}
