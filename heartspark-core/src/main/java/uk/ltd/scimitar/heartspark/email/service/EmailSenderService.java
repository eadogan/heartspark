package uk.ltd.scimitar.heartspark.email.service;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.email.domain.EmailTemplate;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

@Service
public class EmailSenderService implements Serializable {

    private final transient JavaMailSender mailSender;
    private final transient PebbleEngine pebbleEngine;

    @Autowired
    public EmailSenderService(final JavaMailSender mailSender,
                              final PebbleEngine pebbleEngine) {
        this.mailSender = mailSender;
        this.pebbleEngine = pebbleEngine;
    }

    public void sendSimpleMessage(final String to,
                                  final String subject,
                                  final EmailTemplate template,
                                  final Map<String, Object> context) throws IOException {
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("info@heartspark.singles");
        message.setSubject(subject);
        message.setText(generateContent(pebbleEngine.getTemplate(template.templateName()), context));
        mailSender.send(message);
    }

    private String generateContent(final PebbleTemplate compiledTemplate,
                                   final Map<String, Object> context) throws IOException {
        final Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);
        return writer.toString();
    }

}
