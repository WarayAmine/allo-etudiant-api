package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByAskedProfileIdLikeAndDoneIsFalse(String askedProfileId);
    List<Notification> findByAskedProfileIdLikeAndDoneIsTrue(String askedProfileId);
    List<Notification> findByAskedProfileIdLikeAndAskerProfileIdLikeAndAnnounceIdAndDoneIsFalse(String askedProfileId, String askerProfileId, String announceId);
}
