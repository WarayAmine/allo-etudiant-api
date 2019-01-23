package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {

    Profile findByEmail(String email);
}
