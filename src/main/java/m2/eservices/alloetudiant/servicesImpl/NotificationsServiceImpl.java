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

                    String askerEmailBody = "Bonjour "+asker.getLastName()+" "+asker.getFirstName()+",\n\n";
                    askerEmailBody += "Il semble qu'un accord est bien établi entre vous et "+asked.getLastName()+" "+asked.getFirstName()+" ";
                    askerEmailBody += "concernant l'annonce "+dto.getNotification().getAnnounceTitle()+".\n";
                    askerEmailBody += "Désormais votre adresse mail est envoyée à "+asked.getFirstName()+" afin de prendre contact avec vous.\n";
                    askerEmailBody += "Adresse mail de "+asked.getFirstName()+" : "+asked.getEmail()+".\n\n";
                    askerEmailBody += "L'équipe alloétudiants vous remercie pour votre confiance.\n\n";
                    askerEmailBody += "alloétudiants Team.";

                    String askedEmailBody = "Bonjour "+asked.getLastName()+" "+asked.getFirstName()+",\n\n";
                    askedEmailBody += "Il semble qu'un accord est bien établi entre vous et "+asker.getLastName()+" "+asker.getFirstName()+" ";
                    askedEmailBody += "concernant l'annonce "+dto.getNotification().getAnnounceTitle()+".\n";
                    askedEmailBody += "Désormais votre adresse mail est envoyée à "+asker.getFirstName()+" afin de prendre contact avec vous.\n";
                    askedEmailBody += "Adresse mail de "+asker.getFirstName()+" : "+asker.getEmail()+".\n\n";
                    askedEmailBody += "L'équipe alloétudiants vous remercie pour votre confiance.\n\n";
                    askedEmailBody += "alloétudiants Team.";

                    mailingService.sendEmail(asker.getEmail(),"alloétudiants - "+dto.getNotification().getAnnounceTitle(),askerEmailBody);
                    mailingService.sendEmail(asked.getEmail(),"alloétudiants - "+dto.getNotification().getAnnounceTitle(),askedEmailBody);
                } else if (notification.getAnswer() == NotificationAnswer.DECLINED){

                    String askerEmailBody = "Bonjour "+asker.getLastName() + " " + asker.getFirstName() +",\n\n";
                    askerEmailBody += "Nous sommes au regret de vous informer que votre invitation envoyée à "+asked.getLastName()+" "+asked.getFirstName() + " ";
                    askerEmailBody += "concernant l'annonce "+dto.getNotification().getAnnounceTitle() + " n'a pas été acceptée.\n\n";
                    askerEmailBody += "L'équipe alloétudiants vous remercie pour votre confiance.\n\n";
                    askerEmailBody += "alloétudiants Team.";

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
