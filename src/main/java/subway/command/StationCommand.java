package subway.command;

import java.util.Arrays;

public enum StationCommand implements Command {
    ADD("1", "역 등록"),
    DELETE("2", "역 삭제"),
    READ("3", "역 조회"),
    BACK("B", "돌아가기");

    private static final String INVALID_COMMAND_MESSAGE = "선택할 수 없는 기능입니다";

    private final String command;
    private final String description;

    StationCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static StationCommand convert(String command) {
        return Arrays.stream(values())
                .filter(stationCommand -> stationCommand.isSameCommand(command))
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
