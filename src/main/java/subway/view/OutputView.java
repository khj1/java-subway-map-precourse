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

    public void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println(makeMainMenu());
        System.out.println();
    }

    private String makeMainMenu() {
        return Arrays.stream(MainCommand.values())
                .map(mainCommand -> String.format("%s. %s", mainCommand.getCommand(), mainCommand.getDescription()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void printStationMenu() {
        System.out.println("## 역 관리 화면");
        System.out.println(makeStationMenu());
        System.out.println();
    }

    private String makeStationMenu() {
        return Arrays.stream(StationCommand.values())
                .map(stationCommand -> String.format("%s. %s", stationCommand.getCommand(), stationCommand.getDescription()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
