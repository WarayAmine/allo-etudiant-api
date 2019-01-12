package m2.eservices.alloetudiant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.Gender;
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
public class Profile {

    @Id
    private ObjectId id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private int phoneNumber;

    private String bio;

    private Gender gender;
}
