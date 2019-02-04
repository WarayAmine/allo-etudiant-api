package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String>{

}
