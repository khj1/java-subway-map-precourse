package subway.view.ouput;

import subway.command.Command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface OutputView {

    String INFO_PREFIX = "[INFO] %s";
    String SEPARATOR = "---";
    String ERROR_PREFIX = "[ERROR] ";
    String MENU_FORMAT = "%s. %s";

    default void printMenu() {
    }

    default void printList() {
    }

    default void printRegisterResult() {
    }

    default void printDeleteResult() {
    }

    static void printError(IllegalArgumentException error) {
        System.out.print(ERROR_PREFIX);
        System.out.println(error.getMessage());
        System.out.println();
    }

    default String makeMenu(Command[] commands) {
        return Arrays.stream(commands)
                .map(this::toFormatted)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String toFormatted(Command command) {
        return String.format(MENU_FORMAT, command.getCommand(), command.getDescription());
    }

    default String makeFormattedList(List<?> list) {
        return list.stream()
                .map(element -> String.format(INFO_PREFIX, element))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
