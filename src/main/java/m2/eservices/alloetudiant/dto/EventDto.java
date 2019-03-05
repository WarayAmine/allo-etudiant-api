package m2.eservices.alloetudiant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import m2.eservices.alloetudiant.common.JsonDateDeserializer;
import m2.eservices.alloetudiant.common.JsonDateSerializer;
import m2.eservices.alloetudiant.enumerations.AnnounceType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String profileId;

    private AnnounceType announceType;

    private String title;

    private String address;

    private String imgUrl;

    private String description;

    /*    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        @JsonDeserialize(using= JsonDateDeserializer.class)
        @JsonSerialize(using = JsonDateSerializer.class)*/
//    private List<Date> dates;
    private String dates;


}
