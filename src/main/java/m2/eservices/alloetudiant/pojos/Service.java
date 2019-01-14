package m2.eservices.alloetudiant.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.enumerations.WeekDay;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "services")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    private String id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    private String profileId;

    private AnnounceType announceType;

    private String title;

    private String address;

    private String description;

    private Subject subject;

    private float price;

    private String icon;

    private List<WeekDay> days;

}
