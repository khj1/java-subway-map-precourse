package subway.domain;

import java.util.List;
import java.util.Objects;

public class Line {

    private final Name name;
    private final Sections sections;

    public Line(String name, Sections sections) {
        this.name = Name.of(name);
        this.sections = sections;
    }

    public static Line of(String name, Sections sections) {
        return new Line(name, sections);
    }

    public String getName() {
        return name.toString();
    }

    public List<Station> getSections() {
        return sections.get();
    }

    public boolean contains(Station station) {
        return sections.contains(station);
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
        return Objects.hash(name, sections);
    }
}
