package subway.domain;

import java.util.Objects;

public class Station {
    private Name name;

    public Station(String name) {
        this.name = Name.of(name);
    }

    public static Station create(String name) {
        return new Station(name);
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
