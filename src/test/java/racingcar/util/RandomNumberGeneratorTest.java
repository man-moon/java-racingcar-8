package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void 무작위_0_이상_9_이하_숫자를_생성() {
        RandomNumberGenerator generator = new RandomNumberGeneratorImpl();

        int number = generator.generate();

        Assertions.assertThat(number).isBetween(0, 9);
    }
}
