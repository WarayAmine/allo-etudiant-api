package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.ObjectInput;

public interface ProfileRepository extends MongoRepository<Profile, ObjectId> {
}
