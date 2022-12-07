package subway.view;

import java.util.Arrays;

public enum MainCommand {
    STATION("1", "역 관리"),
    LINE("2", "노선 관리"),
    SECTION("3", "구간 관리"),
    PRINT_LINES("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private static final String INVALID_COMMAND_MESSAGE = "선택할 수 없는 기능입니다";

    private final String command;
    private final String description;

    MainCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static MainCommand convert(String command) {
        return Arrays.stream(values())
                .filter(mainCommand -> mainCommand.isSameCommand(command))
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
