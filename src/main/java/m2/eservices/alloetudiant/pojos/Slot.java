package m2.eservices.alloetudiant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.enumerations.WeekDay;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slot {

    private WeekDay day;

    private Date startTime;

    private Date endTime;
}
