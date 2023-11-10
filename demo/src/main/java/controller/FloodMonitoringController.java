package controller;

import models.Reading;
import models.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FloodMonitoringService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FloodMonitoringController {
    private final FloodMonitoringService floodMonitoringService;

    @Autowired
    public FloodMonitoringController(FloodMonitoringService floodMonitoringService) {
        this.floodMonitoringService = floodMonitoringService;
    }

    @GetMapping("/stations")
    public ResponseEntity<List<Station>> getStations() {
        return ResponseEntity.ok(floodMonitoringService.getStations());
    }

    @GetMapping("/stations/{stationId}/readings")
    public ResponseEntity<List<Reading>> getReadingsForStation(@PathVariable String stationId) {
        return ResponseEntity.ok(floodMonitoringService.getReadingsForStationLast24Hours(stationId));
    }
}
