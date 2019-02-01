package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.pojos.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationTokenRepository extends MongoRepository<VerificationToken, String>{
    VerificationToken findByToken(String token);

    VerificationToken findByProfile(Profile profile);
}
