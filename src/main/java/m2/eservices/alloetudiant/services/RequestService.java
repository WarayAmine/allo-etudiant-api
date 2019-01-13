package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.RequestCreateDto;
import m2.eservices.alloetudiant.pojos.Request;

import java.util.List;

public interface RequestService {
    List<Request> getRequests();
    Request createRequest(RequestCreateDto dto);
}
