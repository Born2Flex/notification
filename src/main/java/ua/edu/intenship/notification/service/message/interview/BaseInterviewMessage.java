package ua.edu.intenship.notification.service.message.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.intenship.notification.service.enumeration.MessageType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseInterviewMessage {
    private String interviewerEmail;
    private String candidateEmail;
    private MessageType messageType;
}
