package m2.eservices.alloetudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.AnnounceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String profileId;

    private AnnounceType announceType;

    private String title;

    private String address;

    private String imgUrl;

    private String description;

    private String dates;


}
