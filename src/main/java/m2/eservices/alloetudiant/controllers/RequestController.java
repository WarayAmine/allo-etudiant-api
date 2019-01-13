package m2.eservices.alloetudiant.controllers;

import m2.eservices.alloetudiant.dto.RequestCreateDto;
import m2.eservices.alloetudiant.pojos.Request;
import m2.eservices.alloetudiant.services.RequestService;
import m2.eservices.alloetudiant.services.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Request> getRequests(){
        return requestService.getRequests();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Request createRequest(@RequestBody RequestCreateDto dto){
        return requestService.createRequest(dto);
    }
}
