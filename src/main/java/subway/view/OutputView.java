package subway.view;

import subway.domain.StationRepository;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] %s";

    public void printStations() {
        StationRepository.stations()
                .forEach(station -> System.out.printf(INFO_PREFIX, station));
    }
}
