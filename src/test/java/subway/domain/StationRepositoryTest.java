package subway.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StationRepositoryTest {

    @Test
    void 지하철_역_이름은_중복될_수_없다() {
        StationRepository.addStation(Station.create("안양"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StationRepository.addStation(Station.create("안양")));
    }
}
