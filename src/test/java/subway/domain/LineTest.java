package subway.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    void 상행_종점과_하행_종점을_입력받는다() {
        Sections sections = Sections.create(List.of(Station.create("안양역"), Station.create("금정역")));
        Line line = Line.of("1호선", sections);

        assertThat(line.getSections())
                .containsExactly(Station.create("안양역"), Station.create("금정역"));
    }
}
