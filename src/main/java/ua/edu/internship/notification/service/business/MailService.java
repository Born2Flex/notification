package ua.edu.internship.notification.service.business;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import ua.edu.internship.notification.service.message.interview.InterviewScheduledMessage;
import ua.edu.internship.notification.service.message.user.BaseUserMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public void sendInterviewNotification(InterviewScheduledMessage message) {
        log.info("Trying to send interview notification to {} and {}",
                message.getInterviewerEmail(), message.getCandidateEmail());
        Context context = new Context();
        context.setVariables(message.toMap());
        String emailText = templateEngine.process(message.getMessageType().getTemplateName(), context);
        handleSendEmail(message.getInterviewerEmail(), "Interview Notification", emailText);
        handleSendEmail(message.getCandidateEmail(), "Interview Notification", emailText);
    }

    public void sendUserNotification(BaseUserMessage message) {
        log.info("Trying to send user notification to {}", message.getEmail());
        Context context = new Context();
        context.setVariables(message.toMap());
        String emailText = templateEngine.process(message.getMessageType().getTemplateName(), context);
        handleSendEmail(message.getEmail(), "User Notification", emailText);
    }

    private void handleSendEmail(String to, String subject, String text) {
        try {
            sendEmail(to, subject, text);
            log.info("Notification email sent to: {}", to);
        } catch (MessagingException e) {
            log.error("Failed to send notification email to: {}", to, e);
        }
    }

    private void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        mailSender.send(message);
    }
}
