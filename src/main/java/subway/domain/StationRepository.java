package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final String DUPLICATED_STATION_MESSAGE = "해당 역은 이미 존재합니다";

    private static final List<Station> stations = new ArrayList<>();
    private static final String REGISTERD_STATION_NOT_DELETABLE = "노선에 등록된 역은 제거할 수 없습니다";
    private static final String STATION_NOT_FOUND = "해당 역은 존재하지 않습니다";

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

    public static boolean deleteStation(Station station) {
        if (LineRepository.contains(station)) {
            throw new IllegalArgumentException(REGISTERD_STATION_NOT_DELETABLE);
        }
        return stations.remove(station);
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(STATION_NOT_FOUND));
    }
}
