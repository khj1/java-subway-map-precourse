package subway.view;

import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] %s";
    private static final String SEPARATOR = "---";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printStations() {
        System.out.println("## 역 목록");
        System.out.println(makeStations());
    }

    private String makeStations() {
        return StationRepository.stations().stream()
                .map(station -> String.format(INFO_PREFIX, station))
                .collect(Collectors.joining(System.lineSeparator()));
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
        return Arrays.stream(SectionCommand.values())
                .map(sectionCommand -> String.format("%s. %s", sectionCommand.getCommand(), sectionCommand.getDescription()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void printLines() {
        System.out.println("## 지하철 노선도");
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printLineName(line.getName());
            printSections(line.getStations());
            System.out.println();
        }
    }

    private void printLineName(String name) {
        System.out.printf(INFO_PREFIX, name);
        System.out.println();
        System.out.printf(INFO_PREFIX, SEPARATOR);
        System.out.println();
    }

    private void printSections(List<Station> sections) {
        System.out.println(makeSections(sections));
    }

    private String makeSections(List<Station> sections) {
        return sections.stream()
                .map(station -> String.format(INFO_PREFIX, station))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void printStationRegisterResult() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public void printStationDeleteResult() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public void printSectionRegisterResult() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public void printLineDeleteResult() {
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void printLineRegisterResult() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public void printLineNames() {
        System.out.println("## 노선 목록");
        List<Line> lines = LineRepository.lines();
        List<String> lineNames = lines.stream()
                .map(Line::getName)
                .collect(Collectors.toList());

        System.out.println(makeLineNames(lineNames));
    }

    private String makeLineNames(List<String> lineNames) {
        return lineNames.stream()
                .map(lineName -> String.format(INFO_PREFIX, lineName))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void printSectionDeleteResult() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public void printError(IllegalArgumentException error) {
        System.out.print(ERROR_PREFIX);
        System.out.println(error.getMessage());
    }
}
