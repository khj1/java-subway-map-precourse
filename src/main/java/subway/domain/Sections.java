package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sections {

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
}
