package subway.command;

import java.util.List;

public interface Command {

    String getCommand();

    String getDescription();

    List<Command> values();
}
