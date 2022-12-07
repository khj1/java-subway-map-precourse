package subway.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StationRepositoryTest {

    @Test
    void 지하철_역_이름은_중복될_수_없다() {
        StationRepository.addStation(Station.create("안양"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StationRepository.addStation(Station.create("안양")));
    }

    @Test
    void 지하철_역_목록을_조회한다() {
        StationRepository.addStation(Station.create("명학"));
        StationRepository.addStation(Station.create("금정"));

        assertThat(StationRepository.stations())
                .containsExactly(Station.create("안양"), Station.create("명학"), Station.create("금정"));
    }
}
