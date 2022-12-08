package subway.controller;

import subway.domain.Station;

import java.util.List;

public enum InitLines {
    LINE_2("2호선", List.of(Station.create("교대역"), Station.create("강남역"), Station.create("역삼역"))),
    LINE_3("3호선", List.of(Station.create("교대역"), Station.create("남부터미널역"), Station.create("양재역"), Station.create("매봉역"))),
    LINE_BUNDANG("신분당선", List.of(Station.create("강남역"), Station.create("양재역"), Station.create("양재시민의숲역")));

    private final String lineName;
    private final List<Station> sections;

    InitLines(String lineName, List<Station> sections) {
        this.lineName = lineName;
        this.sections = sections;
    }

    public String getLineName() {
        return lineName;
    }

    public List<Station> getSections() {
        return sections;
    }
}
