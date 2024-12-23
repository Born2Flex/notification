package ua.edu.intenship.notification.service.enumeration;

import lombok.Getter;

@Getter
public enum MessageType {
    USER_REGISTERED("user_registered_template"),
    USER_DELETED("user_deleted_template"),
    INTERVIEW_SCHEDULED("interview_scheduled_template");

    private final String emailTemplate;

    MessageType(String emailTemplate) {
        this.emailTemplate = emailTemplate;
    }
}
