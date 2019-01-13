package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.ProfileCreateDto;
import m2.eservices.alloetudiant.pojos.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProfileService {
    List<Profile> getProfiles();
    Profile createProfile(ProfileCreateDto dto);
}
