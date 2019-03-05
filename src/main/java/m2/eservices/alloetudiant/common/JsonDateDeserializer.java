package m2.eservices.alloetudiant.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateDeserializer extends JsonDeserializer<Date> {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//    yyyy-MM-dd'T'hh:mm:ss.SSS'Z'
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String str = p.getText().trim();
        try {
            return format.parse(str);
        } catch (ParseException e) {
            // Handle exception here
        }
        return ctxt.parseDate(str);
    }
}
