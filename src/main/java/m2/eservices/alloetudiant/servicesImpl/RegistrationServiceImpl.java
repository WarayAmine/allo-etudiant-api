package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.config.OnRegistrationCompleteEvent;
import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.dto.RegisterProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.pojos.VerificationToken;
import m2.eservices.alloetudiant.repositories.ProfileRepository;
import m2.eservices.alloetudiant.repositories.VerificationTokenRepository;
import m2.eservices.alloetudiant.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Lazy
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

//    @Override
//    public Profile register(ProfileDto dto) {
//        Profile profile = new Profile();
//        profile.setFirstName(dto.getFirstName());
//        profile.setLastName(dto.getLastName());
//        profile.setEmail(dto.getEmail());
//        profile.setBio(dto.getBio());
//        profile.setGender(dto.getGender());
//        profile.setPhoneNumber(dto.getPhoneNumber());
//        return profileRepository.save(profile);
//    }

    @Override
    public String register(RegisterProfileDto dto) {
        if (profileRepository.findByEmail(dto.getEmail())!=null){
            return "409 This email is already associated to another user account";
        };

        String hashedPassword = bCryptPasswordEncoder.encode(dto.getPassword());
        Profile profile = new Profile();
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setPassword(hashedPassword);
        profile.setEmail(dto.getEmail());
        profile.setGender(dto.getGender());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setEnabled(false);
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        profile.setRoles(roles);
        profile = profileRepository.save(profile);

        if (profile.getId() == null)
            return "We encoutred an error creating your account, please try later";

        try {
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(profile));
        } catch (Exception e) {
            verificationTokenRepository.delete(
                    verificationTokenRepository.findByProfile(profile));
            profileRepository.delete(profile);
            return "Cannot send confirmation mail, please try later";
        }

        return "An email has been sent for confirmation";
    }

    @Override
    public String confirmation(String token){

        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if(verificationToken == null){
            return "Token is not valid";
        }

        Profile profile = verificationToken.getProfile();

        Calendar cal = Calendar.getInstance();
        if((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0)
            return "Token is expired";

        profile.setEnabled(true);
        profileRepository.save(profile);
        verificationTokenRepository.delete(verificationToken);
        return "Confirmation succeded";
    }
}
