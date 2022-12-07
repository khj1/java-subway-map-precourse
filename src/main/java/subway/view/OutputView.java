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

    public void printLineMenu() {
        System.out.println("## 노선 관리 화면");
        System.out.println(makeLineMenu());
        System.out.println();
    }

    private String makeLineMenu() {
        return Arrays.stream(LineCommand.values())
                .map(lineCommand -> String.format("%s. %s", lineCommand.getCommand(), lineCommand.getDescription()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void printSectionMenu() {
        System.out.println("## 구간 관리 화면");
        System.out.println(makeSectionMenu());
        System.out.println();
    }

    private String makeSectionMenu() {
        return Arrays.stream(LineCommand.values())
                .map(sectionCommand -> String.format("%s. %s", sectionCommand.getCommand(), sectionCommand.getDescription()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
