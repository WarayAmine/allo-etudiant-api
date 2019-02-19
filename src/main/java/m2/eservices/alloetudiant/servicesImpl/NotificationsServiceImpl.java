package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.dto.NotificationDto;
import m2.eservices.alloetudiant.dto.NotificationProfileDto;
import m2.eservices.alloetudiant.enumerations.NotificationAnswer;
import m2.eservices.alloetudiant.pojos.Notification;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.repositories.NotificationRepository;
import m2.eservices.alloetudiant.repositories.ProfileRepository;
import m2.eservices.alloetudiant.services.MailingService;
import m2.eservices.alloetudiant.services.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationsServiceImpl implements NotificationsService{

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    MailingService mailingService;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification createNotification(NotificationDto dto) {

        if(notificationRepository.findByAskedProfileIdLikeAndAskerProfileIdLikeAndAnnounceIdAndDoneIsFalse(
                dto.getAskedProfileId(),
                dto.getAskerProfileId(),
                dto.getAnnounceId()).size() == 0){
            System.out.println();
            Notification notification = new Notification();
            notification.setAskerProfileId(dto.getAskerProfileId());
            notification.setAskedProfileId(dto.getAskedProfileId());
            notification.setAnnounceId(dto.getAnnounceId());
            notification.setAnnounceTitle(dto.getAnnounceTitle());
            notification.setAnnounceType(dto.getAnnounceType());
            notification.setDone(false);
            notification.setAnswer(NotificationAnswer.NOANSWER);

            return notificationRepository.save(notification);
        } else {
            return null;
        }
    }

    @Override
    public List<NotificationProfileDto> getNotDoneNotificationsByAskedProfileId(String code, boolean done) {
        List<NotificationProfileDto> response = new ArrayList<>();
        List<Notification> notifications = null;
        if(!done){
            notifications = notificationRepository.findByAskedProfileIdLikeAndDoneIsFalse(code);
        } else {
            notifications = notificationRepository.findByAskedProfileIdLikeAndDoneIsTrue(code);
        }
        for (Notification notif: notifications){
            response.add(new NotificationProfileDto(notif,profileRepository.findById(notif.getAskerProfileId()).get()));
        }
        return response;
    }

    @Override
    public List<NotificationProfileDto> answerNotification(String id, String profileId, NotificationProfileDto dto) {

        if(notificationRepository.findById(id).isPresent()){
            Notification notification = dto.getNotification();
            notification.setDone(true);
            notificationRepository.save(notification);

            if(profileRepository.findById(notification.getAskerProfileId()).isPresent()
                    && profileRepository.findById(notification.getAskedProfileId()).isPresent()){

                Profile asker = profileRepository.findById(notification.getAskerProfileId()).get();
                Profile asked = profileRepository.findById(notification.getAskedProfileId()).get();


                if(notification.getAnswer() == NotificationAnswer.ACCEPTED){

                    String askerEmailBody = "Hey, vous avez un accord avec " + asked.getLastName() + " " + asked.getFirstName() + " pour l'annonce : " + dto.getNotification().getAnnounceTitle();
                    askerEmailBody += "\nPour que vous puissiez communiquer, voici l'adresse email de "+asked.getFirstName();
                    askerEmailBody += "\nNous avons lui envoyé également votre adresse email pour qu'il puisse vous contacter en premier : "+asked.getEmail();
                    askerEmailBody += "\nMerci pour votre confiance, bon apprentissage.";
                    askerEmailBody += "\n \nalloétudiants.";

                    String askedEmailBody = "Hey, vous avez un accord avec " + asker.getLastName() + " " + asker.getFirstName() + " pour l'annonce : " + dto.getNotification().getAnnounceTitle();
                    askedEmailBody += "\nPour que vous puissiez communiquer, voici l'adresse email de "+asker.getFirstName();
                    askedEmailBody += "\nNous avons lui envoyé également votre adresse email pour qu'il puisse vous contacter en premier : "+asker.getEmail();
                    askedEmailBody += "\nMerci pour votre confiance, bon apprentissage.";
                    askedEmailBody += "\n \nalloétudiants.";

                    mailingService.sendEmail(asker.getEmail(),"alloétudiants - "+dto.getNotification().getAnnounceTitle(),askerEmailBody);
                    mailingService.sendEmail(asked.getEmail(),"alloétudiants - "+dto.getNotification().getAnnounceTitle(),askedEmailBody);
                } else if (notification.getAnswer() == NotificationAnswer.DECLINED){

                    String askerEmailBody = "Hey, "+asked.getLastName() + " " + asked.getFirstName() + " n'a pas accepté votre demande.";
                    askerEmailBody += "\n Il est possible qu'il a accepté une autre demande ou qu'il souhaite annuler ça demande";
                    askerEmailBody += "\n Nous vous conseillons de publier une demande ou une proposition de service pour trouver ce que vous cherchez.";
                    askerEmailBody += "\n Merci pour votre confiance, bon apprentissage.";
                    askerEmailBody += "\n \n alloétudiants.";

                    mailingService.sendEmail(asker.getEmail(),"alloétudiants - " + dto.getNotification().getAnnounceTitle(), askerEmailBody);
                } else {
                    System.out.println("NO ANSWER FOUND");
                    return null;
                }

                List<NotificationProfileDto> response = new ArrayList<>();
                List<Notification> notifications = notificationRepository.findByAskedProfileIdLikeAndDoneIsFalse(profileId);
                for (Notification notif: notifications){
                    response.add(new NotificationProfileDto(notif,profileRepository.findById(notif.getAskerProfileId()).get()));
                }
                return response;
            }

        }
        System.out.println("NO ANSWER FOUND");
        return null;
    }

}
