package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.OfferDto;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.pojos.Offer;

import java.util.List;

public interface OffersService {
    List<Offer> getAllOffers();
    Offer createOffer(OfferDto dto);
    Offer findOfferById(String id);
    List<Offer> getOffersBySubject(Subject subject);
    List<Offer> getOffersByProfileId(String id);
}
