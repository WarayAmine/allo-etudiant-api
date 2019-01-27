package m2.eservices.alloetudiant.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
}
