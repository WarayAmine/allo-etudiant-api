package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.dto.AnnouncementDto;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.pojos.Offer;
import m2.eservices.alloetudiant.pojos.Request;
import m2.eservices.alloetudiant.repositories.EventRepository;
import m2.eservices.alloetudiant.repositories.OfferRepository;
import m2.eservices.alloetudiant.repositories.RequestRepository;
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
    EventRepository eventRepository;

    @Autowired
    RequestsService requestsService;
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    OffersService offersService;
    @Autowired
    OfferRepository offerRepository;

    @Override
    public List<AnnouncementDto> getAnnouncementsByProfileID(String id) {
        List<Event> events = eventsService.getEventsByProfileId(id);
        List<Request> requests = requestsService.getRequestsByProfileId(id);
        List<Offer> offers = offersService.getOffersByProfileId(id);
        List<AnnouncementDto> announcements = new ArrayList<>();
        for (Event e: events
             ) {
            AnnouncementDto announcement = new AnnouncementDto();
            announcement.setAnnounceType(e.getAnnounceType());
            announcement.setCreatedDate(e.getCreatedDate());
            announcement.setEvent(e);
            announcement.setRequest(null);
            announcement.setOffer(null);
            announcements.add(announcement);
        }
        for (Request r: requests
                ) {
            AnnouncementDto announcement = new AnnouncementDto();
            announcement.setAnnounceType(r.getAnnounceType());
            announcement.setCreatedDate(r.getCreatedDate());
            announcement.setEvent(null);
            announcement.setRequest(r);
            announcement.setOffer(null);
            announcements.add(announcement);
        }
        for (Offer o: offers
                ) {
            AnnouncementDto announcement = new AnnouncementDto();
            announcement.setAnnounceType(o.getAnnounceType());
            announcement.setCreatedDate(o.getCreatedDate());
            announcement.setEvent(null);
            announcement.setRequest(null);
            announcement.setOffer(o);
            announcements.add(announcement);
        }
        announcements.sort(Comparator.comparing(AnnouncementDto::getCreatedDate).reversed());
        return announcements;
    }

    @Override
    public List<AnnouncementDto> deleteAnnouncement(String id, AnnounceType type) {
        String profileId = null;
        switch (type){
            case EVENT:
                profileId = eventsService.findEventById(id).getProfileId();
                eventRepository.deleteById(id);
                break;
            case OFFER:
                profileId = offersService.findOfferById(id).getProfileId();
                offerRepository.deleteById(id);
                break;
            case REQUEST:
                profileId = requestsService.findRequestById(id).getProfileId();
                requestRepository.deleteById(id);
                break;
            default:
                break;
        }
        return getAnnouncementsByProfileID(profileId);
    }
}
