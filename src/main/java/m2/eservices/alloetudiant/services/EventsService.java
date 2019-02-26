package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;

import java.util.List;
import java.util.Optional;

public interface EventsService {
    List<Event> getAllEvents();
//    List<Event> getAllEvents(int page);
    Event createEvent(EventDto dto);
    Event findEventById(String id);
    List<Event> getEventsByTitle(String title);
    List<Event> getEventsByProfileId(String id);

}
