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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
@JsonDeserialize(using= JsonDateDeserializer.class)
@JsonSerialize(using = JsonDateSerializer.class)
    private List<Date> dates;

}
