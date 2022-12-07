package subway.domain;

import java.util.List;

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
}
