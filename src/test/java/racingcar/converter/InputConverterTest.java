package racingcar.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputConverterTest {
    private final InputConverter converter = new InputConverter();

//    @Test
//    void 자동차_이름은_5자_초과_불가능() {
//        String carName = "Ferrari";
//
//        assertThatThrownBy(() -> converter.getCarNames(carName))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 자동차_이름은_공백_불가능() {
//        String carName = "";
//
//        assertThatThrownBy(() -> converter.getCarNames(carName))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 자동차_이름은_1자_이상_5자_이하_가능() {
//        String minLengthCarName = "A";
//        String maxLengthCarName = "ABCD";
//
//        List<String> minLengthCarNames = converter.getCarNames(minLengthCarName);
//        List<String> maxLengthCarNames = converter.getCarNames(maxLengthCarName);
//
//        assertThat(minLengthCarNames.size()).isEqualTo(1);
//        assertThat(minLengthCarNames.getFirst()).isEqualTo("A");
//        assertThat(maxLengthCarNames.size()).isEqualTo(1);
//        assertThat(maxLengthCarNames.getFirst()).isEqualTo("ABCD");
//    }

    @Test
    void 자동차_이름은_쉼표로_나누어짐() {
        String carNamesInput = "A,AB,ABC,ABCD,ABCDE";

        List<String> carNames = converter.getCarNames(carNamesInput);
        List<String> correctCarNames = List.of("A", "AB", "ABC", "ABCD", "ABCDE");

        assertThat(carNames).isEqualTo(correctCarNames);
    }

    @Test
    void 자동차_이름은_중복_불가능() {
        String carNamesInput = "ABC,ABC,DEF";

        assertThatThrownBy(() -> converter.getCarNames(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수는_0_이상_INT_MAX_이하() {
        String minMoveCountInput = "0";
        String maxMoveCountInput = String.valueOf(Integer.MAX_VALUE);

        int minMoveCount = converter.getMoveCount(minMoveCountInput);
        int maxMoveCount = converter.getMoveCount(maxMoveCountInput);

        assertThat(minMoveCount).isEqualTo(0);
        assertThat(maxMoveCount).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void 이동_횟수가_0_미만이면_예외_발생() {
        String moveCountInput = "-1";

        assertThatThrownBy(() -> converter.getMoveCount(moveCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수가_INT_MAX_이상이면_예외_발생() {
        String moveCountInput = String.valueOf(Long.MAX_VALUE);

        assertThatThrownBy(() -> converter.getMoveCount(moveCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
