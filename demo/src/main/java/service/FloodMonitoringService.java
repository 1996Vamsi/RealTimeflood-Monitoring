package service;

import models.Reading;
import models.ReadingResponse;
import models.Station;
import models.StationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FloodMonitoringService {
    private final RestTemplate restTemplate;
    private final String baseApiUrl = "http://environment.data.gov.uk/flood-monitoring/id/";

    @Autowired
    public FloodMonitoringService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Station> getStations() {
        try {
            String url = baseApiUrl + "stations";
            ResponseEntity<StationResponse> response = restTemplate.getForEntity(url, StationResponse.class);
            return response.getBody() != null ? response.getBody().getItems() : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Reading> getReadingsForStationLast24Hours(String stationId) {
        try {
            LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
            String url = baseApiUrl + "stations/" + stationId + "/readings?_sorted&_limit=100"; // Assuming you want to limit to 100 readings.
            ResponseEntity<ReadingResponse> response = restTemplate.getForEntity(url, ReadingResponse.class);
            List<Reading> allReadings = response.getBody() != null ? response.getBody().getItems() : new ArrayList<>();

            // Filter readings within the last 24 hours
            return allReadings.stream()
                    .filter(reading -> reading.getDateTime().isAfter(twentyFourHoursAgo))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

