package m2.eservices.alloetudiant.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.Gender;
import m2.eservices.alloetudiant.enumerations.Grade;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "profiles")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private Date createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @LastModifiedDate
    private Date lastModifiedDate;

    private String firstName;

    private String lastName;

    private String password;

    @Indexed(unique = true)
    private String email;

    private String phoneNumber;

    private String bio;

    private Grade grade;

    private Gender gender;

    private List<String> roles;

    private boolean enabled;
}
