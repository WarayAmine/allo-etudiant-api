package m2.eservices.alloetudiant.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.pojos.Profile;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Data
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private Profile profile;

    public OnRegistrationCompleteEvent(Profile profile) {
        super(profile);
        this.profile = profile;
    }
}
