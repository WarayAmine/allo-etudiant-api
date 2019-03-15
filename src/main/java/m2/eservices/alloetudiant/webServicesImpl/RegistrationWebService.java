package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.dto.RegisterMessage;
import m2.eservices.alloetudiant.dto.RegisterProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import m2.eservices.alloetudiant.servicesImpl.RegistrationServiceImpl;
import m2.eservices.alloetudiant.webServices.RegistrationApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RegistrationWebService implements RegistrationApi {

    @Autowired
    RegistrationServiceImpl registrationService;

    @Override
    public RegisterMessage register(RegisterProfileDto dto, HttpServletResponse response) {
        String message = registrationService.register(dto);
        if(message.startsWith("409")){
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
        return new RegisterMessage(message);
    }

    @Override
    public String confirmRegistration(String token) {
        return registrationService.confirmation(token);
    }

}
