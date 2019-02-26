package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.dto.AnnouncementDto;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.pojos.Offer;
import m2.eservices.alloetudiant.pojos.Request;
import m2.eservices.alloetudiant.services.AnnouncementsService;
import m2.eservices.alloetudiant.services.EventsService;
import m2.eservices.alloetudiant.services.OffersService;
import m2.eservices.alloetudiant.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService{

    @Autowired
    EventsService eventsService;

    @Autowired
    RequestsService requestsService;

    @Autowired
    OffersService offersService;

    @Override
    public List<AnnouncementDto> getAnnouncementsByProfileID(String id) {
        List<Event> events = eventsService.getEventsByProfileId(id);
        List<Request> requests = requestsService.getRequestsByProfileId(id);
        List<Offer> offers = offersService.getOffersByProfileId(id);
        List<AnnouncementDto> announcements = new ArrayList<>();
        for (Event e: events
             ) {
            AnnouncementDto announcement = new AnnouncementDto();
            announcement.setId(e.getId());
            announcement.setCreatedDate(e.getCreatedDate());
            announcement.setAnnounceType(e.getAnnounceType());
            announcement.setDescription(e.getDescription());
            announcement.setTitle(e.getTitle());
            announcement.setProfileId(e.getProfileId());
            announcements.add(announcement);
        }
        for (Request r: requests
                ) {
            AnnouncementDto announcement = new AnnouncementDto();
            announcement.setId(r.getId());
            announcement.setCreatedDate(r.getCreatedDate());
            announcement.setAnnounceType(r.getAnnounceType());
            announcement.setDescription(r.getDescription());
            announcement.setTitle(r.getTitle());
            announcement.setProfileId(r.getProfileId());
            announcements.add(announcement);
        }
        for (Offer o: offers
                ) {
            AnnouncementDto announcement = new AnnouncementDto();
            announcement.setId(o.getId());
            announcement.setCreatedDate(o.getCreatedDate());
            announcement.setAnnounceType(o.getAnnounceType());
            announcement.setDescription(o.getDescription());
            announcement.setTitle(o.getTitle());
            announcement.setProfileId(o.getProfileId());
            announcements.add(announcement);
        }
        announcements.sort(Comparator.comparing(AnnouncementDto::getCreatedDate).reversed());
        return announcements;
    }
}
