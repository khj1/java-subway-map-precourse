package subway.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StationRepositoryTest {

    Station anyang;
    Station myunghak;
    Station geumjung;

    @BeforeEach
    void setUp() {
        anyang = Station.create("안양");
        myunghak = Station.create("명학");
        geumjung = Station.create("금정");
    }

    @Test
    void 지하철_역_이름은_중복될_수_없다() {
        StationRepository.addStation(anyang);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StationRepository.addStation(anyang));
    }

    @Test
    void 지하철_역_목록을_조회한다() {
        StationRepository.addStation(anyang);
        StationRepository.addStation(myunghak);
        StationRepository.addStation(geumjung);

        assertThat(StationRepository.stations())
                .containsExactly(anyang, myunghak, geumjung);
    }

    @Test
    void 이미_노선에_등록된_역은_삭제할_수_없다() {
        Stations sections = Stations.create(List.of(anyang, myunghak));
        Line line = Line.of("1호선", sections);
        LineRepository.addLine(line);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StationRepository.deleteStation(anyang));
    }

    @AfterEach
    void drop() {
        LineRepository.deleteLineByName("1호선");
        StationRepository.deleteStation(anyang);
        StationRepository.deleteStation(myunghak);
        StationRepository.deleteStation(geumjung);
    }
}
