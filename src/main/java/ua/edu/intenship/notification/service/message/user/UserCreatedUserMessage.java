package ua.edu.intenship.notification.service.message.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.edu.intenship.notification.service.enumeration.MessageType;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class UserCreatedUserMessage extends BaseUserMessage {
    public UserCreatedUserMessage(String email, String fullName) {
        super(email, fullName, MessageType.USER_REGISTERED);
    }
}
