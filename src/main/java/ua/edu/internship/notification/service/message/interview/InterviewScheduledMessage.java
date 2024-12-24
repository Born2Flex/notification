package ua.edu.internship.notification.service.message.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.edu.internship.notification.service.enumeration.MessageType;
import ua.edu.internship.notification.service.message.TemplateData;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class InterviewScheduledMessage implements TemplateData {
    private String interviewerEmail;
    private String candidateEmail;
    private MessageType messageType;
    private LocalDateTime plannedDateTime;

    @Override
    public Map<String, Object> toMap() {
        return Map.of("datetime", plannedDateTime);
    }
}
