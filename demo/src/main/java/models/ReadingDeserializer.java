package models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReadingDeserializer extends JsonDeserializer<Reading> {

    @Override
    public Reading deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Reading reading = new Reading();

        JsonNode dateTimeNode = node.get("dateTime");
        if (dateTimeNode != null) {
            String dateTimeStr = dateTimeNode.asText();
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_DATE_TIME);
            reading.setDateTime(dateTime);
        }

        JsonNode valueNode = node.get("value");
        if (valueNode != null) {
            reading.setValue(valueNode.asDouble());
        }

        JsonNode measureNode = node.get("measure");
        if (measureNode != null) {
            reading.setMeasure(measureNode.asText());
        }

        return reading;
    }
}
