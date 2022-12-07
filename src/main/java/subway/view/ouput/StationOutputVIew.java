package subway.view.ouput;

import subway.command.StationCommand;
import subway.domain.Station;
import subway.repository.StationRepository;

import java.util.List;

public class StationOutputVIew implements OutputView {

    private static final String STATION_LIST = "## 역 목록";
    private static final String STATION_MANAGEMENT_VIEW_IS = "## 역 관리 화면";

    @Override
    public void printMenu() {
        System.out.println(STATION_MANAGEMENT_VIEW_IS);
        System.out.println(makeMenu(StationCommand.values()));
        System.out.println();
    }

    @Override
    public void printList() {
        System.out.println(STATION_LIST);
        List<Station> stations = StationRepository.stations();

        System.out.println(makeFormattedList(stations));
    }

    @Override
    public void printRegisterResult() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    @Override
    public void printDeleteResult() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }
}
