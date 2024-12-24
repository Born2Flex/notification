package ua.edu.internship.notification.service.business;

import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import ua.edu.internship.notification.service.enumeration.MessageType;
import ua.edu.internship.notification.service.message.interview.InterviewScheduledMessage;
import ua.edu.internship.notification.service.message.user.UserDeletedMessage;
import java.time.LocalDateTime;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {
    @Mock
    private JavaMailSender mailSender;
    @Mock
    private TemplateEngine templateEngine;
    @InjectMocks
    private MailService underTest;

    @Test
    @DisplayName("Should send email user notification")
    void shouldSendEmailUserNotification() {
        // given
        UserDeletedMessage message = new UserDeletedMessage("test@gmail.com", "John Doe");
        MimeMessage mimeMessage = new MimeMessage((Session) null);
        when(templateEngine.process(eq(MessageType.USER_REGISTERED.getTemplateName()), any(Context.class)))
                .thenReturn("Email body");
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        // when
        underTest.sendUserNotification(message);

        // then
        verify(mailSender).send(mimeMessage);
    }

    @Test
    @DisplayName("Should send email interview notification")
    void shouldSendEmailInterviewNotification() {
        // given
        InterviewScheduledMessage message = new InterviewScheduledMessage("test1@gmail.com",
                "John Doe", "test2@gmail.com", "Bob Martin",
                MessageType.INTERVIEW_SCHEDULED, LocalDateTime.now());
        MimeMessage mimeMessage = new MimeMessage((Session) null);
        when(templateEngine.process(eq(MessageType.INTERVIEW_SCHEDULED.getTemplateName()), any(Context.class)))
                .thenReturn("Email body");
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        // when
        underTest.sendInterviewNotification(message);

        // then
        verify(mailSender, times(2)).send(mimeMessage);
    }
}
