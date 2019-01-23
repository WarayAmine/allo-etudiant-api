package m2.eservices.alloetudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.Gender;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String phoneNumber;

    private String bio;

    private Gender gender;

    private List<String> roles;

}
