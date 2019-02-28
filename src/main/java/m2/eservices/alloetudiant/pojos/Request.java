package m2.eservices.alloetudiant.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import m2.eservices.alloetudiant.enumerations.Grade;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.enumerations.WeekDay;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "requests")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private Date createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @LastModifiedDate
    private Date lastModifiedDate;

    private String profileId;

    private AnnounceType announceType;

    private String title;

    private String address;

    private String description;

    private Subject subject;

    private Grade grade;

    private int hours;

    private float pricePerHour;

    private float total;

    private List<WeekDay> days;

    private String icon;
}
