package m2.eservices.alloetudiant.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Document(collection = "verificationToken")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {

    @Id
    private String id;

    private String token;

    @NotNull
    private Profile profile;

    private Date expiryDate;


}
