package m2.eservices.alloetudiant.controllers;

import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getRequests(){
        return profileService.getProfiles();
    }

    @PostMapping
    public Profile createRequest(@RequestBody ProfileDto dto){
        return profileService.createProfile(dto);
    }
}
