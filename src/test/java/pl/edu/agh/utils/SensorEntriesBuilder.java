package pl.edu.agh.utils;

import pl.edu.agh.model.SensorEntry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SensorEntriesBuilder {
    List<SensorEntry> entries;

    public SensorEntriesBuilder() {
        entries = new ArrayList<>();
    }

    public SensorEntriesBuilder addSensorEntry(String sensorId, long milisecSinceEpoch, int value) {
        entries.add(new SensorEntry(sensorId, new Date(milisecSinceEpoch), value));
        return this;
    }

    public List<SensorEntry> build() {
        return entries;
    }
}
