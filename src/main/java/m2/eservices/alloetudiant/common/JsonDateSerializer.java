package m2.eservices.alloetudiant.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class JsonDateSerializer extends JsonSerializer<Date> {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//    yyyy-MM-dd'T'hh:mm:ss.SSS'Z'
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String dateString = format.format(value);
        gen.writeString(dateString);
    }
}
