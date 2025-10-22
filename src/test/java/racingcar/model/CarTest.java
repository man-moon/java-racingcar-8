package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름은_5자_초과_불가능() {
        assertThatThrownBy(() -> new Car("Ferrari"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_공백_불가능() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_1자_이상_5자_이하_가능() {
        String minLengthCarName = "A";
        String maxLengthCarName = "ABCDE";

        Car minLengthCar = new Car(minLengthCarName);
        Car maxLengthCar = new Car(maxLengthCarName);

        assertThat(minLengthCar.getName()).isEqualTo(minLengthCarName);
        assertThat(maxLengthCar.getName()).isEqualTo(maxLengthCarName);
    }
}
