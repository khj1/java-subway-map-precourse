package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineRepositoryTest {

    Stations sections;

    @BeforeEach
    void setUp() {
        List<Station> stations = List.of(Station.create("안양역"), Station.create("명학역"));
        sections = Stations.create(stations);
    }

    @Test
    void 노선_이름은_종복될_수_없다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LineRepository.addLine(Line.of("1호선", sections)));
    }
}
