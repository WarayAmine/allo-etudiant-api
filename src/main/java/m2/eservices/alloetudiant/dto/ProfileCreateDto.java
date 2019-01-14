package m2.eservices.alloetudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCreateDto {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String email;

    private String phoneNumber;

    private String bio;

    private Gender gender;

}
