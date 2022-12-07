package subway.domain;

public class Station {
    private Name name;

    public Station(String name) {
        this.name = Name.of(name);
    }

    public String getName() {
        return name.toString();
    }

    // 추가 기능 구현
}
