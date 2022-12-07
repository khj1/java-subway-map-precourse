package subway.view.ouput;

import subway.command.LineCommand;
import subway.repository.LineRepository;

import java.util.List;

public class LineOutputView implements OutputView {

    private static final String LINE_LIST_IS = "## 노선 목록";
    private static final String LINE_MANAGEMENT_VIEW_IS = "## 노선 관리 화면";

    @Override
    public void printMenu() {
        System.out.println(LINE_MANAGEMENT_VIEW_IS);
        System.out.println(makeMenu(LineCommand.values()));
        System.out.println();
    }

    @Override
    public void printList() {
        System.out.println(LINE_LIST_IS);
        List<String> lineNames = LineRepository.lineNames();

        System.out.println(makeFormattedList(lineNames));
    }

    @Override
    public void printRegisterResult() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    @Override
    public void printDeleteResult() {
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }
}
