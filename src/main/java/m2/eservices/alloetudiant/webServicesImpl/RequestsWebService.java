package m2.eservices.alloetudiant.webServicesImpl;

import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.webServices.RequestsApi;
import m2.eservices.alloetudiant.dto.RequestDto;
import m2.eservices.alloetudiant.pojos.Request;
import m2.eservices.alloetudiant.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestsWebService implements RequestsApi {
    @Autowired
    private RequestsService requestsService;

    @Override
    public List<Request> getRequests(){
        return requestsService.getAllRequests();
    }

    @Override
    public Request createRequest(@RequestBody RequestDto dto){
        return requestsService.createRequest(dto);
    }

    @Override
    public Request getRequestById(String id) {
        return requestsService.findRequestById(id);
    }

    @Override
    public List<Request> getRequestsBySubject(String subject) {
        String str = subject.toUpperCase();
        return requestsService.getRequestsBySubject(Subject.valueOf(str));
    }

}
