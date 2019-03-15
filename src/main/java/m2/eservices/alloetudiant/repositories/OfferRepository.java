package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.pojos.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OfferRepository extends MongoRepository<Offer, String> {
    List<Offer> findOffersBySubject(Subject subject);
    List<Offer> findByProfileId(String profileId);
}
