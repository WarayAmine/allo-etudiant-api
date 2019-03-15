package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.OfferDto;
import m2.eservices.alloetudiant.pojos.Offer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.OFFERS)
public interface OffersApi {

    @RequestMapping(method = RequestMethod.GET)
    List<Offer> getAllOffers();

    @RequestMapping(method = RequestMethod.POST)
    Offer createAssistance(@RequestBody OfferDto dto);

    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    Offer getOfferById(@PathVariable(value ="id") String id);

    @RequestMapping(method = RequestMethod.GET , value = "/subjects/{subject}")
    List<Offer> getOffersBySubject(@PathVariable(value ="subject") String subject);
}
