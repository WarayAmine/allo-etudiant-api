package m2.eservices.alloetudiant.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.common.JsonDateDeserializer;
import m2.eservices.alloetudiant.common.JsonDateSerializer;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "events")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

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

    private String imgUrl;


/*    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonDeserialize(using= JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)*/
//    private List<Date> dates;
    private String dates;

}
