package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Urls.EVENTS)
public interface EventsApi {

    @RequestMapping(method = RequestMethod.GET)
    List<Event> getAllEvents();

    @RequestMapping(method = RequestMethod.POST)
    Event createEvent(@RequestBody EventDto dto);

}
