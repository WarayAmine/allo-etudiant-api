package m2.eservices.alloetudiant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import m2.eservices.alloetudiant.enumerations.Grade;
import m2.eservices.alloetudiant.enumerations.Subject;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

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

    private Subject subject;

    private Grade grade;

    private int hours;

    private float pricePerHour;

    private float total;

    private List<Slot> timeSlots;

    private String icon;
}
