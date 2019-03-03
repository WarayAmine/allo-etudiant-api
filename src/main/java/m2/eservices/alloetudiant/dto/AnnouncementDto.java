package m2.eservices.alloetudiant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import m2.eservices.alloetudiant.enumerations.WeekDay;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.pojos.Offer;
import m2.eservices.alloetudiant.pojos.Request;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementDto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdDate;

    private AnnounceType announceType;

    private Request request;

    private Event event;

    private Offer offer;

}
