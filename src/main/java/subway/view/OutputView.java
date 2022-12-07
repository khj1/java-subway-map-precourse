package subway.view;

import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] %s";

    public void printStations() {
        StationRepository.stations()
                .forEach(station -> System.out.printf(INFO_PREFIX, station));
    }

    public void printMain() {
        System.out.println(makeMainMenu());
    }

    private String makeMainMenu() {
        return Arrays.stream(MainCommand.values())
                .map(mainCommand -> String.format("%s. %s", mainCommand.getCommand(), mainCommand.getDescription()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
