package subway.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import subway.repository.LineRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineRepositoryTest {

    Stations stations;
    Stations otherStations;

    @BeforeEach
    void setUp() {
        List<Station> stations = List.of(Station.create("안양역"), Station.create("명학역"));
        List<Station> otherStations = List.of(Station.create("사당역"), Station.create("금정역"));

        this.stations = Stations.create(stations);
        this.otherStations = Stations.create(otherStations);
    }

    @Test
    void 노선_이름은_종복될_수_없다() {
        LineRepository.addLine(Line.of("1호선", stations));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LineRepository.addLine(Line.of("1호선", otherStations)));
    }

    @AfterEach
    void drop() {
        LineRepository.deleteLineByName("1호선");
    }
}
