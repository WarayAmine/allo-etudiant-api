package m2.eservices.alloetudiant.config;

import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.pojos.VerificationToken;
import m2.eservices.alloetudiant.repositories.RequestRepository;
import m2.eservices.alloetudiant.repositories.VerificationTokenRepository;
import m2.eservices.alloetudiant.services.MailingService;
import m2.eservices.alloetudiant.services.ProfilesService;
import m2.eservices.alloetudiant.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    MailingService mailingService;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {
        this.confirmRergistration(onRegistrationCompleteEvent);
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    private void confirmRergistration(OnRegistrationCompleteEvent event){
        Profile profile = event.getProfile();
        String token = UUID.randomUUID().toString();

        String destinationAddress = profile.getEmail();
        String subject = "alloétudiant - Confirmation d'inscription";
        String text = "Pour confirmer votre inscription, veuillez cliquez le lien suivant ";

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setProfile(profile);
        verificationToken.setExpiryDate(calculateExpiryDate(SecurityConstants.TOKEN_EXPIRATION));

        verificationTokenRepository.save(verificationToken);

//        String confirmationUrl = "http://localhost:5000/register/confirmation?token=" + token;
        String confirmationUrl = "http://alloetudiantapi.herokuapp.com/register/confirmation?token=" + token;

        mailingService.sendEmail(destinationAddress, subject, text + confirmationUrl);
    }
}
