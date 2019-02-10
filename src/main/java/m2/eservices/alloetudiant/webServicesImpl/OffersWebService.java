package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.dto.OfferDto;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.pojos.Offer;
import m2.eservices.alloetudiant.services.OffersService;
import m2.eservices.alloetudiant.webServices.OffersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OffersWebService implements OffersApi{
    @Autowired
    private OffersService offersService;

    @Override
    public List<Offer> getAllOffers(){
        return offersService.getAllOffers();
    }

    @Override
    public Offer createAssistance(@RequestBody OfferDto dto){
        return offersService.createOffer(dto);
    }

    @Override
    public Offer getOfferById(String id) {
        return offersService.findOfferById(id);
    }

    @Override
    public List<Offer> getOffersBySubject(String subject) {
        String str = subject.toUpperCase();
        return offersService.getOffersBySubject(Subject.valueOf(str));
    }
}
