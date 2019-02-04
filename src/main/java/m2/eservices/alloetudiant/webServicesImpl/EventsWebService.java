package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.services.EventsService;
import m2.eservices.alloetudiant.webServices.EventsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventsWebService implements EventsApi {

    @Autowired
    EventsService eventsService;

    @Override
    public List<Event> getAllEvents() {
        return eventsService.getAllEvents();
    }

//    @Override
//    public List<Event> getAllEvents(@RequestParam(value = "page") int page) {
//        return eventsService.getAllEvents(page);
//    }

    @Override
    public Event createEvent(EventDto dto) {
        return eventsService.createEvent(dto);
    }

    @Override
    public Event getEventById(String id) {
        return eventsService.findEventById(id);
    }
}
