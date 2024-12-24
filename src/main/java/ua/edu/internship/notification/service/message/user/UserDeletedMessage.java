package ua.edu.internship.notification.service.message.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.edu.internship.notification.service.enumeration.MessageType;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class UserDeletedMessage extends BaseUserMessage {
    public UserDeletedMessage(String email, String fullName) {
        super(email, fullName, MessageType.USER_DELETED);
    }
}
