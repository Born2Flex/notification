package ua.edu.internship.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import ua.edu.internship.notification.service.message.interview.InterviewScheduledMessage;
import ua.edu.internship.notification.service.message.user.UserDeletedMessage;
import ua.edu.internship.notification.service.message.user.UserRegisteredMessage;
import java.util.HashMap;
import java.util.Map;

@EnableJms
@Configuration
public class JMSConfig {
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("ua.edu.internship.user.service.message.user.UserRegisteredMessage", UserRegisteredMessage.class);
        typeIdMappings.put("ua.edu.internship.user.service.message.user.UserDeletedMessage", UserDeletedMessage.class);
        typeIdMappings.put("ua.edu.internship.user.service.message.interview.InterviewScheduledMessage", InterviewScheduledMessage.class);
        converter.setTypeIdMappings(typeIdMappings);
        return converter;
    }
}
