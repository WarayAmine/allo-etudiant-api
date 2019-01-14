package m2.eservices.alloetudiant.controllers;

import m2.eservices.alloetudiant.dto.AssistanceDto;
import m2.eservices.alloetudiant.pojos.Assistance;
import m2.eservices.alloetudiant.services.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assistances")
public class AssistanceController {
    @Autowired
    private AssistanceService assistanceService;

    @GetMapping
    public List<Assistance> getAssistances(){
        return assistanceService.getAssistances();
    }

    @GetMapping
    public Assistance createAssistance(@RequestBody AssistanceDto dto){
        return assistanceService.createAssistance(dto);
    }
}
