package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.repositories.EventRepository;
import m2.eservices.alloetudiant.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {
    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event createEvent(EventDto dto) {
        Event event = new Event();
        event.setProfileId(dto.getProfileId());
        event.setAnnounceType(dto.getAnnounceType());
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setAddress(dto.getAddress());
        event.setImgUrl(dto.getImgUrl());
        event.setDates(dto.getDates());
        return eventRepository.save(event);
    }
}
