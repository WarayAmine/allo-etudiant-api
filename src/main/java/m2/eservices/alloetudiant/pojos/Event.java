package m2.eservices.alloetudiant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    private ObjectId id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    private ObjectId profileId;

    private AnnounceType announceType;

    private String title;

    private String address;

    private String description;

}
