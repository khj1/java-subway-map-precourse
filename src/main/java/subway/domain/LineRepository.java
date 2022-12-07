package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String DUPLICATED_LINE_MESSAGE = "해당 노선은 이미 존재합니다.";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validate(line);
        lines.add(line);
    }

    private static void validate(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(DUPLICATED_LINE_MESSAGE);
        }
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
