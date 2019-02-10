package m2.eservices.alloetudiant.servicesImpl;

import m2.eservices.alloetudiant.dto.RequestDto;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.pojos.Request;
import m2.eservices.alloetudiant.repositories.RequestRepository;
import m2.eservices.alloetudiant.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestsServiceImpl implements RequestsService {
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Request createRequest(RequestDto dto) {
        Request request = new Request();
        request.setProfileId(dto.getProfileId());
        request.setAnnounceType(dto.getAnnounceType());
        request.setTitle(dto.getTitle());
        request.setAddress(dto.getAddress());
        request.setDescription(dto.getDescription());
        request.setSubject(dto.getSubject());
        request.setGrade(dto.getGrade());
        request.setHours(dto.getHours());
        request.setPricePerHour(dto.getPricePerHour());
        request.setTotal(dto.getPricePerHour()*dto.getHours());
        request.setSlots(dto.getSlots());
        request.setIcon(dto.getIcon());
        return requestRepository.save(request);
    }

    @Override
    public Request findRequestById(String id) {
        return requestRepository.findById(id).get();
    }

    @Override
    public List<Request> getRequestsBySubject(Subject subject) {
        return  requestRepository.findRequestsBySubject(subject);
    }
}
