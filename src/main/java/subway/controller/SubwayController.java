package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;

public class SubwayController {

    private static final String[] stations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    public SubwayController() {
        init();
    }

    private void init() {
        saveStations();
        saveLines();
    }

    private void saveStations() {
        Arrays.stream(stations)
                .map(Station::create)
                .forEach(StationRepository::addStation);
    }

    private void saveLines() {
        Arrays.stream(InitLines.values())
                .map(initLines -> Line.of(initLines.getLineName(), Sections.create(initLines.getSections())))
                .forEach(LineRepository::addLine);
    }
}
