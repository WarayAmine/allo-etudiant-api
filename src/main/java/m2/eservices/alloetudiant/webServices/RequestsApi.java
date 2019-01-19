package m2.eservices.alloetudiant.webServices;

import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.RequestDto;
import m2.eservices.alloetudiant.pojos.Request;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.REQUESTS)
public interface RequestsApi {

    @RequestMapping(method = RequestMethod.GET)
    List<Request> getRequests();

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Request createRequest(@RequestBody RequestDto dto);
}
