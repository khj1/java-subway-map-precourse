package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    Line line;

    @BeforeEach
    void setUp() {
        Sections sections = Sections.create(List.of(Station.create("안양역"), Station.create("명학역"), Station.create("금정역")));

        line = Line.of("1호선", sections);
    }

    @Test
    void 상행_종점과_하행_종점을_입력받는다() {
        assertThat(line.getSections())
                .containsExactly(Station.create("안양역"), Station.create("명학역"), Station.create("금정역"));
    }

    @Test
    void 노선에_역을_추가할_수_있다() {
        line.addStation(Station.create("서초역"), 2);

        assertThat(line.getSections())
                .containsExactly(
                        Station.create("안양역"), Station.create("서초역"),
                        Station.create("명학역"), Station.create("금정역")
                );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    void 잘못된_역_위치_입력에_관한_유효성_검증(int sequence) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> line.addStation(Station.create("사당역"), sequence));
    }

    @Test
    void 노선의_역을_제거할_수_있다() {
        line.remove(Station.create("안양역"));

        assertThat(line.getSections())
                .containsExactly(Station.create("명학역"), Station.create("금정역"));
    }

    @Test
    void 역_제거시_해당_역이_존재하지_않는_경우_예외_처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> line.remove(Station.create("강남역")));
    }

    @Test
    void 남은_역이_2개_이하일_경우_더이상_제거할_수_없다() {
        line.remove(Station.create("명학역"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> line.remove(Station.create("안양역")));
    }
}
