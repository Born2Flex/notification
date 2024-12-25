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
        handleSendEmail("Interview Notification", emailText,
                message.getCandidateEmail(), message.getInterviewerEmail());
    }

    public void sendUserNotification(BaseUserMessage message) {
        log.info("Trying to send user notification to {}", message.getEmail());
        Context context = new Context();
        context.setVariables(message.toMap());
        String emailText = templateEngine.process(message.getMessageType().getTemplateName(), context);
        handleSendEmail("User Notification", emailText, message.getEmail());
    }

    private void handleSendEmail(String subject, String text, String... to) {
        try {
            sendEmail(subject, text, to);
            log.info("Notification email sent to: {}", (Object[]) to);
        } catch (MessagingException e) {
            log.error("Failed to send notification email to: {}", to, e);
        }
    }

    private void sendEmail(String subject, String text, String... to) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        mailSender.send(message);
    }
}
