package m2.eservices.alloetudiant.repositories;

import m2.eservices.alloetudiant.pojos.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfferRepository extends MongoRepository<Offer, String> {
}
