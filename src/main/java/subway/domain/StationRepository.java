package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String DUPLICATED_STATION_MESSAGE = "해당 역은 이미 존재합니다";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validate(station);
        stations.add(station);
    }

    private static void validate(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_MESSAGE);
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
