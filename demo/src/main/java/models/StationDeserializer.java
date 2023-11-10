package models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StationDeserializer extends JsonDeserializer<Station> {

    @Override
    public Station deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Station station = new Station();

        // Extracting fields from JSON node
        JsonNode idNode = node.get("@id");
        if (idNode != null) {
            String fullId = idNode.asText();
            station.setId(fullId.substring(fullId.lastIndexOf('/') + 1));
        }

        station.setLabel(node.path("label").asText());
        station.setTown(node.path("town").asText());
        station.setRiverName(node.path("riverName").asText());
        station.setCatchmentName(node.path("catchmentName").asText());
        station.setNotation(node.path("notation").asText());
        station.setRloiId(node.path("RLOIid").asText());
        station.setDateOpened(node.path("dateOpened").asText());
        station.setEasting(node.path("easting").asDouble());
        station.setNorthing(node.path("northing").asDouble());
        station.setLat(node.path("lat").asDouble());
        station.setLon(node.path("long").asDouble());
        station.setStationReference(node.path("stationReference").asText());
        station.setStatus(node.path("status").asText());

        // Parsing the measures array
        List<Measure> measures = new ArrayList<>();
        JsonNode measuresNode = node.get("measures");
        if (measuresNode != null && measuresNode.isArray()) {
            for (JsonNode measureNode : measuresNode) {
                Measure measure = new Measure();
                measure.setParameter(measureNode.path("parameter").asText());
                measure.setParameterName(measureNode.path("parameterName").asText());
                measure.setQualifier(measureNode.path("qualifier").asText());
                measure.setUnitName(measureNode.path("unitName").asText());
                measures.add(measure);
            }
        }
        station.setMeasures(measures);

        return station;
    }
}



