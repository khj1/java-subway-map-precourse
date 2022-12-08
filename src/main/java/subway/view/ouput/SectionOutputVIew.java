package subway.view.ouput;

import subway.command.SectionCommand;

public class SectionOutputVIew implements OutputView {

    private static final String SECTION_MANAGEMENT_VIEW_IS = "## 구간 관리 화면";
    private static final String SECTION_REGISTERED = "구간이 등록되었습니다.";
    private static final String SECTION_DELETED = "구간이 삭제되었습니다.";

    @Override
    public void printMenu() {
        System.out.println(SECTION_MANAGEMENT_VIEW_IS);
        System.out.println(makeMenu(SectionCommand.values()));
        System.out.println();
    }

    @Override
    public void printRegisterResult() {
        System.out.printf(INFO_PREFIX, SECTION_REGISTERED);
        System.out.println();
    }

    @Override
    public void printDeleteResult() {
        System.out.printf(INFO_PREFIX, SECTION_DELETED);
        System.out.println();
    }
}
