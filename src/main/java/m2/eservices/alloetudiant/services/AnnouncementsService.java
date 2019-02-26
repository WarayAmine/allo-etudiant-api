package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.AnnouncementDto;

import java.util.List;

public interface AnnouncementsService {

    List<AnnouncementDto> getAnnouncementsByProfileID(String id);
}
