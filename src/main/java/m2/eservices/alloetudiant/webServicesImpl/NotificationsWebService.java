package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.dto.NotificationDto;
import m2.eservices.alloetudiant.dto.NotificationProfileDto;
import m2.eservices.alloetudiant.pojos.Notification;
import m2.eservices.alloetudiant.services.NotificationsService;
import m2.eservices.alloetudiant.webServices.NotificationsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class NotificationsWebService implements NotificationsApi{

    @Autowired
    NotificationsService notificationsService;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationsService.getAllNotifications();
    }

    @Override
    public Notification createNotification(@RequestBody NotificationDto dto, HttpServletResponse response) {
        Notification notification = notificationsService.createNotification(dto);
        if(notification!=null){
            return notification;
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

    @Override
    public List<NotificationProfileDto> getNotDoneNotificationsByAskedProfileId(String id, boolean done) {
        return notificationsService.getNotDoneNotificationsByAskedProfileId(id, done);
    }

    @Override
    public List<NotificationProfileDto> answerNotification(String id, String profileId, NotificationProfileDto dto) {
        return notificationsService.answerNotification(id,profileId,dto);
    }

}
