package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.OfferDto;
import m2.eservices.alloetudiant.pojos.Offer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Urls.OFFERS)
public interface OffersApi {

    @RequestMapping(method = RequestMethod.GET)
    List<Offer> getAllOffers();

    @RequestMapping(method = RequestMethod.POST)
    Offer createAssistance(@RequestBody OfferDto dto);
}
