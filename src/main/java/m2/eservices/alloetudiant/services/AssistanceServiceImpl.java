package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.AssistanceDto;
import m2.eservices.alloetudiant.pojos.Assistance;
import m2.eservices.alloetudiant.repositories.AssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceServiceImpl implements AssistanceService {

    @Autowired
    AssistanceRepository assistanceRepository;

    @Override
    public List<Assistance> getAssistances() {
        return assistanceRepository.findAll();
    }

    @Override
    public Assistance createAssistance(AssistanceDto dto) {
        Assistance assistance = new Assistance();
        assistance.setProfileId(dto.getProfileId());
        assistance.setAnnounceType(dto.getAnnounceType());
        assistance.setTitle(dto.getTitle());
        assistance.setAddress(dto.getAddress());
        assistance.setDescription(dto.getDescription());
        assistance.setSubject(dto.getSubject());
        assistance.setPrice(dto.getPrice());
        assistance.setDays(dto.getDays());
        return assistanceRepository.save(assistance);
    }
}
