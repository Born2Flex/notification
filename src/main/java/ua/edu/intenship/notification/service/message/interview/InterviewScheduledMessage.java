package ua.edu.intenship.notification.service.message.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.intenship.notification.service.enumeration.MessageType;
import ua.edu.intenship.notification.service.message.TemplateData;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewScheduledMessage implements TemplateData {
    private String interviewerEmail;
    private String interviewerFullName;
    private String candidateEmail;
    private String candidateFullName;
    private MessageType messageType;
    private LocalDateTime plannedDateTime;

    @Override
    public Map<String, Object> toMap() {
        return Map.of("interviewer", interviewerFullName,
                "candidate", candidateFullName,
                "datetime", plannedDateTime);
    }
}
