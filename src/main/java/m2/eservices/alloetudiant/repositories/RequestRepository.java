package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Request;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<Request, ObjectId> {
}
