package models;

import java.util.List;

public class ReadingResponse {
    private List<Reading> items;

    public List<Reading> getItems() {
        return items;
    }

    public void setItems(List<Reading> items) {
        this.items = items;
    }
}