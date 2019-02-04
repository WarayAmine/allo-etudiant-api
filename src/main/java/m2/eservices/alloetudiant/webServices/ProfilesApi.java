package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.PROFILES)
public interface ProfilesApi {

    @RequestMapping(method = RequestMethod.GET)
    List<Profile> getAllProfiles();

    @RequestMapping(method = RequestMethod.POST)
    Profile createProfile(@RequestBody ProfileDto dto);

    @RequestMapping(method = RequestMethod.GET , value = "/id/{email}")
    String getProfileIdByEmail(@PathVariable(value ="email") String email);
}
