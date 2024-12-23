package ua.edu.intenship.notification.service.message.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.intenship.notification.service.enumeration.MessageType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseUserMessage {
    private String email;
    private MessageType messageType;
}
