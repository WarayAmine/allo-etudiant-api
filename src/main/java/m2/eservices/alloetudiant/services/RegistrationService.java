package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.dto.RegisterProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.WebRequest;

public interface RegistrationService {

    String register(RegisterProfileDto dto);

    String confirmation(String token);
}