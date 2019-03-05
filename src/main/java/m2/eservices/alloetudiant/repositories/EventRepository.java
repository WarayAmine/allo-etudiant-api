package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String>{

    List<Event> findByProfileId(String profileId);
}
