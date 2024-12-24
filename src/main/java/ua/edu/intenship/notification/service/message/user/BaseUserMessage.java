package ua.edu.intenship.notification.service.message.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.intenship.notification.service.enumeration.MessageType;
import ua.edu.intenship.notification.service.message.TemplateData;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseUserMessage implements TemplateData {
    private String email;
    private String fullName;
    private MessageType messageType;

    @Override
    public Map<String, Object> toMap() {
        return Map.of("email", email,
                "fullName", fullName);
    }
}
