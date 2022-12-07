package subway.domain;

public class Line {
    private Name name;

    public Line(String name) {
        this.name = Name.of(name);
    }

    public String getName() {
        return name.toString();
    }

    // 추가 기능 구현
}
