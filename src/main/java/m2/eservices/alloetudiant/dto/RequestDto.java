package m2.eservices.alloetudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.AnnounceType;
import m2.eservices.alloetudiant.enumerations.Grade;
import m2.eservices.alloetudiant.enumerations.Subject;
import m2.eservices.alloetudiant.pojos.Slot;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

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

    private List<Slot> slots;

    private String icon;
}
