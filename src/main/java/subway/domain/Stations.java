package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Stations {

    private static final String CANNOT_ADD_STATION_MESSAGE = "해당 위치에 역을 추가할 수 없습니다.";
    private static final String STATION_NOT_FOUND_MESSAGE = "해당 역이 존재하지 않습니다";
    private static final String STATION_NOT_DELETABLE_MESSAGE = "더 이상 제거할 수 없습니다";
    private static final int STATIONS_LOWER_BOUND = 2;

    private final List<Station> stations;

    public Stations(List<Station> stations) {
        this.stations = new LinkedList<>(stations);
    }

    public static Stations create(List<Station> stations) {
        return new Stations(stations);
    }

    public List<Station> get() {
        return Collections.unmodifiableList(stations);
    }

    public boolean contains(Station station) {
        return stations.contains(station);
    }

    public void add(Station station, int sequence) {
        validateSequence(sequence);
        stations.add(sequence - 1, station);
    }

    private void validateSequence(int sequence) {
        if (sequence > stations.size() || sequence < 1) {
            throw new IllegalArgumentException(CANNOT_ADD_STATION_MESSAGE);
        }
    }

    public void remove(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException(STATION_NOT_FOUND_MESSAGE);
        }
        if (stations.size() <= STATIONS_LOWER_BOUND) {
            throw new IllegalArgumentException(STATION_NOT_DELETABLE_MESSAGE);
        }
        stations.remove(station);
    }
}
