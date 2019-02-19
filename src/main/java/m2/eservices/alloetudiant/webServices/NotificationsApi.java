package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.NotificationDto;

import m2.eservices.alloetudiant.dto.NotificationProfileDto;
import m2.eservices.alloetudiant.pojos.Notification;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(Urls.NOTIFICATIONS)
public interface NotificationsApi {

    @RequestMapping(method = RequestMethod.GET)
    List<Notification> getAllNotifications();

    @RequestMapping(method = RequestMethod.POST)
    Notification createNotification(@RequestBody NotificationDto dto, HttpServletResponse response);

    @RequestMapping(method = RequestMethod.GET, value = "/asked/{id}")
    List<NotificationProfileDto> getNotDoneNotificationsByAskedProfileId(@PathVariable(value ="id") String id, @RequestParam(value = "done", required = true) boolean done);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/{profileId}")
    List<NotificationProfileDto> answerNotification(@PathVariable(value = "id") String id, @PathVariable(value = "profileId") String profileId, @RequestBody NotificationProfileDto dto);

}
