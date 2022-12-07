package subway.command;

import java.util.Arrays;

public enum SectionCommand {
    ADD("1", "구간 등록"),
    DELETE("2", "구간 삭제"),
    BACK("B", "돌아가기");

    private static final String INVALID_COMMAND_MESSAGE = "선택할 수 없는 기능입니다";

    private final String command;
    private final String description;

    SectionCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static SectionCommand convert(String command) {
        return Arrays.stream(values())
                .filter(sectionCommand -> sectionCommand.isSameCommand(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    private boolean isSameCommand(String command) {
        return this.command.equals(command.toUpperCase());
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
