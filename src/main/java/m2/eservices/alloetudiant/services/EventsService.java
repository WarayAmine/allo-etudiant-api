package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;

import java.util.List;

public interface EventsService {
    List<Event> getAllEvents();
//    List<Event> getAllEvents(int page);
    Event createEvent(EventDto dto);
}
