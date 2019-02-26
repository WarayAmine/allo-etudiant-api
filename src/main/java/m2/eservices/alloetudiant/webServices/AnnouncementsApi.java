package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.AnnouncementDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Urls.ANNOUNCEMENTS)
public interface AnnouncementsApi {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    List<AnnouncementDto> getAnnouncementsByProfileId(@PathVariable(value ="id") String id);
}
