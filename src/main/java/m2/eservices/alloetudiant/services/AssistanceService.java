package m2.eservices.alloetudiant.services;

import m2.eservices.alloetudiant.dto.AssistanceDto;
import m2.eservices.alloetudiant.pojos.Assistance;

import java.util.List;

public interface AssistanceService {
    List<Assistance> getAssistances();
    Assistance createAssistance(AssistanceDto dto);
}
