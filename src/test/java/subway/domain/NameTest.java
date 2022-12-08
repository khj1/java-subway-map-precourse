package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "아"})
    void 이름_길이_유효성_검증(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.of(name));
    }
}
