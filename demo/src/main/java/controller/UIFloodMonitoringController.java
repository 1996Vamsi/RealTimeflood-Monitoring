package controller;

import models.Reading;
import models.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.FloodMonitoringService;

import java.util.List;

@Controller
public class UIFloodMonitoringController {

    private final FloodMonitoringService floodMonitoringService;

    @Autowired
    public UIFloodMonitoringController(FloodMonitoringService floodMonitoringService) {
        this.floodMonitoringService = floodMonitoringService;
    }

    @GetMapping("/stations")
    public String showStationsPage(Model model) {
        List<Station> stations = floodMonitoringService.getStations();
        model.addAttribute("stations", stations);
        return "index";
    }

    @GetMapping("/stations/{stationId}/readings")
    public String showReadingsPage(@PathVariable String stationId, Model model) {
        List<Reading> readings = floodMonitoringService.getReadingsForStationLast24Hours(stationId);
        model.addAttribute("readings", readings);
        model.addAttribute("stationId", stationId);
        return "index";
    }
}
