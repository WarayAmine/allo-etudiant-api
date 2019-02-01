package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.services.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailingServiceImpl implements MailingService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String destination, String subject, String body) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(destination);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);

    }
}
