package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;

import java.util.List;

public interface ProfilesService {
    List<Profile> getAllProfiles();
    Profile createProfile(ProfileDto dto);
    Profile findByEmail(String email);
    String findIdByEmail(String email);
    Profile findById(String id);
}
