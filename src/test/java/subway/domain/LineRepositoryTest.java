package subway.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineRepositoryTest {

    @Test
    void 노선_이름은_종복될_수_없다() {
        List<Station> stations = List.of(Station.create("안양역"), Station.create("명학역"));
        Sections sections = Sections.create(stations);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LineRepository.addLine(Line.of("1호선", sections)));
    }
}
