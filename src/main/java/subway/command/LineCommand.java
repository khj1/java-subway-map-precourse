package subway.command;

import java.util.Arrays;

public enum LineCommand implements Command {
    ADD("1", "노선 등록"),
    DELETE("2", "노선 삭제"),
    READ("3", "노선 조회"),
    BACK("B", "돌아가기");

    private static final String INVALID_COMMAND_MESSAGE = "선택할 수 없는 기능입니다";

    private final String command;
    private final String description;

    LineCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static LineCommand convert(String command) {
        return Arrays.stream(values())
                .filter(lineCommand -> lineCommand.isSameCommand(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    private boolean isSameCommand(String command) {
        return this.command.equals(command.toUpperCase());
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
