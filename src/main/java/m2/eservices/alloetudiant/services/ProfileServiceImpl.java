package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.ProfileCreateDto;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile createProfile(ProfileCreateDto dto) {
        Profile profile = new Profile();
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setUsername(dto.getUsername());
        profile.setPassword(dto.getPassword());
        profile.setEmail(dto.getEmail());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setBio(dto.getBio());
        profile.setGender(dto.getGender());
        return profile;
    }
}
