package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sections {

    private static final String CANNOT_ADD_STATION_MESSAGE = "해당 위치에 역을 추가할 수 없습니다.";
    private final List<Station> sections;

    public Sections(List<Station> stations) {
        this.sections = new LinkedList<>(stations);
    }

    public static Sections create(List<Station> stations) {
        return new Sections(stations);
    }

    public List<Station> get() {
        return Collections.unmodifiableList(sections);
    }

    public boolean contains(Station station) {
        return sections.contains(station);
    }

    public void add(Station station, int sequence) {
        validateSequence(sequence);
        sections.add(sequence - 1, station);
    }

    private void validateSequence(int sequence) {
        if (sequence > sections.size() || sequence < 1) {
            throw new IllegalArgumentException(CANNOT_ADD_STATION_MESSAGE);
        }
    }
}
