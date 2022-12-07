package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sections {

    private final List<Station> sections;

    public Sections(List<Station> sections) {
        this.sections = new LinkedList<>(sections);
    }

    public static Sections create(Station upBoundTerminus, Station downBoundTerminus) {
        return new Sections(List.of(upBoundTerminus, downBoundTerminus));
    }

    public List<Station> get() {
        return Collections.unmodifiableList(sections);
    }
}
