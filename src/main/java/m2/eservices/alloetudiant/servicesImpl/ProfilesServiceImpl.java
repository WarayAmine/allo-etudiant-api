package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.repositories.ProfileRepository;
import m2.eservices.alloetudiant.services.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfilesServiceImpl implements ProfilesService {

    @Autowired
    private ProfileRepository profileRepository;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile createProfile(ProfileDto dto) {
//        String hashedPassword = bCryptPasswordEncoder.encode(dto.getPassword());
        Profile profile = new Profile();
        profile.setPassword(dto.getPassword());
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setEmail(dto.getEmail());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setBio(dto.getBio());
        profile.setGrade(dto.getGrade());
        profile.setGender(dto.getGender());
        profile.setEnabled(false);
//        profile.getRoles().add("USER");
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        profile.setRoles(roles);
        return profileRepository.save(profile);
    }

    @Override
    public Profile findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    @Override
    public String findIdByEmail(String email) {
        return profileRepository.findByEmail(email).getId();
    }

    @Override
    public Profile findById(String id) {
        return profileRepository.findProfileById(id);
    }
}
