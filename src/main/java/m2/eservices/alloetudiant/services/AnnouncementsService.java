package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.AnnouncementDto;
import m2.eservices.alloetudiant.enumerations.AnnounceType;

import java.util.List;

public interface AnnouncementsService {

    List<AnnouncementDto> getAnnouncementsByProfileID(String id);

    List<AnnouncementDto> deleteAnnouncement(String id, AnnounceType type);
}
