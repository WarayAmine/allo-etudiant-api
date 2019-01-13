package m2.eservices.alloetudiant.controllers;

import m2.eservices.alloetudiant.dto.ProfileCreateDto;
import m2.eservices.alloetudiant.dto.RequestCreateDto;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.pojos.Request;
import m2.eservices.alloetudiant.services.ProfileService;
import m2.eservices.alloetudiant.services.ProfileServiceImpl;
import m2.eservices.alloetudiant.services.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Profile> getRequests(){
        return profileService.getProfiles();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Profile createRequest(@RequestBody ProfileCreateDto dto){
        return profileService.createProfile(dto);
    }
}
