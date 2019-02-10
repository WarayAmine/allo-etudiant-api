package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.dto.OfferDto;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.pojos.Offer;
import m2.eservices.alloetudiant.repositories.OfferRepository;
import m2.eservices.alloetudiant.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffersServiceImpl implements OffersService {

    @Autowired
    OfferRepository offerRepository;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer createOffer(OfferDto dto) {
        Offer offer = new Offer();
        offer.setProfileId(dto.getProfileId());
        offer.setAnnounceType(dto.getAnnounceType());
        offer.setTitle(dto.getTitle());
        offer.setAddress(dto.getAddress());
        offer.setDescription(dto.getDescription());
        offer.setSubject(dto.getSubject());
        offer.setPrice(dto.getPrice());
        offer.setDays(dto.getDays());
        return offerRepository.save(offer);
    }

    @Override
    public Offer findOfferById(String id) {
        return offerRepository.findById(id).get();
    }

    @Override
    public List<Offer> getOffersBySubject(Subject subject) {
        return  offerRepository.findOffersBySubject(subject);
    }
}
