package racingcar.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    private final InputParser parser = new InputParser();

    @Test
    void 자동차_이름은_5자_초과_불가능() {
        String carName = "Ferrari";

        assertThatThrownBy(() -> parser.parse(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_공백_불가능() {
        String carName = "";

        assertThatThrownBy(() -> parser.parse(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_1자_이상_5자_이하_가능() {
        String minLengthCarName = "A";
        String maxLengthCarName = "ABCD";

        List<String> minLengthCarNames = parser.parse(minLengthCarName);
        List<String> maxLengthCarNames = parser.parse(maxLengthCarName);

        assertThat(minLengthCarNames.size()).isEqualTo(1);
        assertThat(minLengthCarNames.getFirst()).isEqualTo("A");
        assertThat(maxLengthCarNames.size()).isEqualTo(1);
        assertThat(maxLengthCarNames.getFirst()).isEqualTo("ABCD");
    }


    @Test
    void 자동차_이름은_쉼표로_나누어짐() {
        String carNamesInput = "A,AB,ABC,ABCD,ABCDE";

        List<String> carNames = parser.parse(carNamesInput);
        List<String> correctCarNames = List.of("A", "AB", "ABC", "ABCD", "ABCDE");

        assertThat(carNames).isEqualTo(correctCarNames);
    }
}
