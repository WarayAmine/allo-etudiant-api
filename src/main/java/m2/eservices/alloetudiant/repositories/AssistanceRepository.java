package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Assistance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssistanceRepository extends MongoRepository<Assistance, String> {
}
