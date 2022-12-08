package subway.domain;

import java.util.List;
import java.util.Objects;

public class Line {

    private final Name name;
    private final Stations stations;

    public Line(String name, Stations sections) {
        this.name = Name.of(name);
        this.stations = sections;
    }

    public static Line of(String name, Stations sections) {
        return new Line(name, sections);
    }

    public String getName() {
        return name.toString();
    }

    public List<Station> getStations() {
        return stations.get();
    }

    public boolean contains(Station station) {
        return stations.contains(station);
    }

    public void addStation(Station station, int sequence) {
        stations.add(station, sequence);
    }

    public void remove(Station station) {
        stations.remove(station);
    }

    public boolean isSameName(String name) {
        return this.name.equals(Name.of(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stations);
    }
}
