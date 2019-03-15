package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.ProfileDto;
import m2.eservices.alloetudiant.dto.RegisterMessage;
import m2.eservices.alloetudiant.dto.RegisterProfileDto;
import m2.eservices.alloetudiant.pojos.Profile;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(Urls.REGISTER)
public interface RegistrationApi {

//    @RequestMapping(method = RequestMethod.POST)
//    Profile register(@RequestBody ProfileDto dto);

   @RequestMapping(method = RequestMethod.POST)
    RegisterMessage register(@RequestBody RegisterProfileDto dto, HttpServletResponse response);

   @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    String confirmRegistration(@RequestParam("token") String token);

}
