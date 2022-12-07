package subway.view.ouput;

import subway.command.SectionCommand;

public class SectionOutputVIew implements OutputView {

    private static final String SECTION_MANAGEMENT_VIEW_IS = "## 구간 관리 화면";

    @Override
    public void printMenu() {
        System.out.println(SECTION_MANAGEMENT_VIEW_IS);
        System.out.println(makeMenu(SectionCommand.values()));
        System.out.println();
    }

    @Override
    public void printRegisterResult() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    @Override
    public void printDeleteResult() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }
}
