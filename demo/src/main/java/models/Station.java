package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
@JsonDeserialize(using = StationDeserializer.class)
public class Station {
    private String id;
    private String label;
    private String town;
    private String riverName;
    private String catchmentName;
    private String notation;
    private String rloiId;
    private String dateOpened;
    private double easting;
    private double northing;
    private double lat;
    private double lon;
    private String stationReference;
    private String status;
    private List<Measure> measures;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getCatchmentName() {
        return catchmentName;
    }

    public void setCatchmentName(String catchmentName) {
        this.catchmentName = catchmentName;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getRloiId() {
        return rloiId;
    }

    public void setRloiId(String rloiId) {
        this.rloiId = rloiId;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public double getEasting() {
        return easting;
    }

    public void setEasting(double easting) {
        this.easting = easting;
    }

    public double getNorthing() {
        return northing;
    }

    public void setNorthing(double northing) {
        this.northing = northing;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getStationReference() {
        return stationReference;
    }

    public void setStationReference(String stationReference) {
        this.stationReference = stationReference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }
}

