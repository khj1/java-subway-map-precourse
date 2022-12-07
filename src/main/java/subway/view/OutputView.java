package subway.view;

import subway.command.Command;
import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] %s";
    private static final String SEPARATOR = "---";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MENU_FORMAT = "%s. %s";
    private static final String STATION_MANAGEMENT_VIEW_IS = "## 역 관리 화면";
    private static final String LINE_MANAGEMENT_VIEW_IS = "## 노선 관리 화면";
    private static final String SECTION_MANAGEMENT_VIEW_IS = "## 구간 관리 화면";
    private static final String MAIN_VIEW = "## 메인 화면";
    private static final String STATION_LIST = "## 역 목록";
    private static final String SUBWAY_MAP_IS = "## 지하철 노선도";
    private static final String LINE_LIST_IS = "## 노선 목록";

    public void printStations() {
        System.out.println(STATION_LIST);
        List<Station> stations = StationRepository.stations();

        System.out.println(makeFormattedList(stations));
    }

    public void printMainMenu() {
        System.out.println(MAIN_VIEW);
        System.out.println(makeMenu(MainCommand.values()));
        System.out.println();
    }

    private static String toFormatted(Command command) {
        return String.format(MENU_FORMAT, command.getCommand(), command.getDescription());
    }

    public void printStationMenu() {
        System.out.println(STATION_MANAGEMENT_VIEW_IS);
        System.out.println(makeMenu(StationCommand.values()));
        System.out.println();
    }

    public void printLineMenu() {
        System.out.println(LINE_MANAGEMENT_VIEW_IS);
        System.out.println(makeMenu(LineCommand.values()));
        System.out.println();
    }

    public void printSectionMenu() {
        System.out.println(SECTION_MANAGEMENT_VIEW_IS);
        System.out.println(makeMenu(SectionCommand.values()));
        System.out.println();
    }

    public void printLines() {
        System.out.println(SUBWAY_MAP_IS);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printLineName(line.getName());
            printSections(line.getStations());
        }
    }

    private void printLineName(String name) {
        System.out.printf(INFO_PREFIX, name);
        System.out.println();
        System.out.printf(INFO_PREFIX, SEPARATOR);
        System.out.println();
    }

    public void printLineNames() {
        System.out.println(LINE_LIST_IS);
        List<String> lineNames = LineRepository.lineNames();

        System.out.println(makeFormattedList(lineNames));
    }

    private void printSections(List<Station> sections) {
        System.out.println(makeFormattedList(sections));
        System.out.println();
    }

    public void printStationRegisterResult() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public void printStationDeleteResult() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public void printLineRegisterResult() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public void printLineDeleteResult() {
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void printSectionRegisterResult() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public void printSectionDeleteResult() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public static void printError(IllegalArgumentException error) {
        System.out.print(ERROR_PREFIX);
        System.out.println(error.getMessage());
    }

    private String makeMenu(Command[] commands) {
        return Arrays.stream(commands)
                .map(OutputView::toFormatted)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String makeFormattedList(List<?> list) {
        return list.stream()
                .map(element -> String.format(INFO_PREFIX, element))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
