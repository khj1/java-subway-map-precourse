package subway.view.ouput;

import subway.command.MainCommand;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;

import java.util.List;

public class MainOutputView implements OutputView {

    private static final String MAIN_VIEW = "## 메인 화면";
    private static final String SUBWAY_MAP_IS = "## 지하철 노선도";

    @Override
    public void printMenu() {
        System.out.println(MAIN_VIEW);
        System.out.println(makeMenu(MainCommand.values()));
        System.out.println();
    }

    public void printMap() {
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
        printSeparator();
    }

    private void printSeparator() {
        System.out.printf(INFO_PREFIX, SEPARATOR);
        System.out.println();
    }

    private void printSections(List<Station> sections) {
        System.out.println(makeFormattedList(sections));
        System.out.println();
    }
}
