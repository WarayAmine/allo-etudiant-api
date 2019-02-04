package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;

import java.util.List;
import java.util.Optional;

public interface EventsService {
    List<Event> getAllEvents();
    Event createEvent(EventDto dto);
    Event findEventById(String id);
}
