package ua.edu.intenship.notification.service.message.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.edu.intenship.notification.service.enumeration.MessageType;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class UserDeletedUserMessage extends BaseUserMessage {
    public UserDeletedUserMessage(String email) {
        super(email, MessageType.USER_DELETED);
    }
}
