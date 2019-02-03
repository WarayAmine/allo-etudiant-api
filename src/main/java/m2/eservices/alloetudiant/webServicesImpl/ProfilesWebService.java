package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.services.ProfilesService;
import m2.eservices.alloetudiant.webServices.ProfilesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfilesWebService implements ProfilesApi {
    @Autowired
    private ProfilesService profilesService;

    @Override
    public List<Profile> getAllProfiles(){
        return profilesService.getAllProfiles();
    }

    @Override
    public Profile createProfile(@RequestBody ProfileDto dto){
        return profilesService.createProfile(dto);
    }

    @Override
    public String getProfileIdByEmail(String email) {
        return profilesService.findIdByEmail(email);
    }
}
