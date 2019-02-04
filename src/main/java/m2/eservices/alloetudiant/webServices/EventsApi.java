package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.EVENTS)
public interface EventsApi {

//    @RequestMapping(method = RequestMethod.GET)
//    List<Event> getAllEvents(@RequestParam(value = "p") int page);

    @RequestMapping(method = RequestMethod.GET)
    List<Event> getAllEvents();

    @RequestMapping(method = RequestMethod.POST)
    Event createEvent(@RequestBody EventDto dto);

    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    Event getEventById(@PathVariable(value ="id") String id);

}
