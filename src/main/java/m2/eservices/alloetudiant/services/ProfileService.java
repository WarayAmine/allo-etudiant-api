package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getProfiles();
    Profile createProfile(ProfileDto dto);
}
