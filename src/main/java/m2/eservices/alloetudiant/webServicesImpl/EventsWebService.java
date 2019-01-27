package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.services.EventsService;
import m2.eservices.alloetudiant.webServices.EventsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventsWebService implements EventsApi {

    @Autowired
    EventsService eventsService;

    @Override
    public List<Event> getAllEvents() {
        System.out.println(
        eventsService.getAllEvents().toString());
        return eventsService.getAllEvents();
    }

    @Override
    public Event createEvent(EventDto dto) {
        return eventsService.createEvent(dto);
    }
}
