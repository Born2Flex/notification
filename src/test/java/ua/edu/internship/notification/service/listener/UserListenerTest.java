package ua.edu.internship.notification.service.listener;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.edu.internship.notification.service.business.MailService;
import ua.edu.internship.notification.service.message.user.UserRegisteredMessage;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserListenerTest {
    @Mock
    private MailService mailService;
    @InjectMocks
    private UserListener underTest;

    @Test
    @DisplayName("Should send notification via mail service when receive message")
    void shouldSendNotificationWhenReceiveMessage() {
        // given
        UserRegisteredMessage message = new UserRegisteredMessage("test@gmail.com", "John Doe");

        // when
        underTest.processUserMessage(message);

        // then
        verify(mailService).sendUserNotification(message);
    }
}
