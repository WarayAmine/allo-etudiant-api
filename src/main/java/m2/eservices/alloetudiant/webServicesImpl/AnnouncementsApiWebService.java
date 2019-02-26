package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.dto.AnnouncementDto;
import m2.eservices.alloetudiant.services.AnnouncementsService;
import m2.eservices.alloetudiant.webServices.AnnouncementsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnouncementsApiWebService implements AnnouncementsApi {

    @Autowired
    AnnouncementsService announcementsService;

    @Override
    public List<AnnouncementDto> getAnnouncementsByProfileId(String id) {
        return announcementsService.getAnnouncementsByProfileID(id);
    }
}
