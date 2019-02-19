package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.dto.NotificationDto;
import m2.eservices.alloetudiant.dto.NotificationProfileDto;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.pojos.Notification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface NotificationsService {

    List<Notification> getAllNotifications();

    Notification createNotification(NotificationDto dto);

    List<NotificationProfileDto> getNotDoneNotificationsByAskedProfileId(String code, boolean done);

    List<NotificationProfileDto> answerNotification(String id, String profileId, NotificationProfileDto dto);
}
