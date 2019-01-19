package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.RequestDto;
import m2.eservices.alloetudiant.pojos.Request;

import java.util.List;

public interface RequestsService {
    List<Request> getAllRequests();
    Request createRequest(RequestDto dto);
}
