package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {

    private static final String DUPLICATED_LINE_MESSAGE = "해당 노선은 이미 존재합니다.";
    private static final String LINE_NAME_NOT_FOUND_MESSAGE = "해당 노선은 존재하지 않습니다.";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static List<String> lineNames() {
        return lines.stream()
                .map(Line::getName)
                .collect(Collectors.toList());
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

    public static boolean contains(Station station) {
        return lines().stream()
                .anyMatch(line -> line.contains(station));
    }

    public static Line findByName(String name) {
        return lines().stream()
                .filter(line -> line.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LINE_NAME_NOT_FOUND_MESSAGE));
    }
}
