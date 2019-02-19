package m2.eservices.alloetudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.pojos.Notification;
import m2.eservices.alloetudiant.pojos.Profile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationProfileDto {

    private Notification notification;

    private Profile profile;
}
