package m2.eservices.alloetudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import m2.eservices.alloetudiant.enumerations.NotificationAnswer;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {

    private String askerProfileId;

    private String askedProfileId;

    private String announceId;

    private String announceTitle;

    private AnnounceType announceType;

    private String message;

    private boolean done;

    private NotificationAnswer answer;

}
