package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.RequestDto;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.pojos.Request;

import java.util.List;

public interface RequestsService {
    List<Request> getAllRequests();
    Request createRequest(RequestDto dto);
    Request findRequestById(String id);
    List<Request> getRequestsBySubject(Subject subject);
}
