package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputTest extends NsTest {

    private final InputView inputView = new InputViewImpl();

    @Test
    void 자동차_이름_입력_테스트() {
        String input = "pobi,woni";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String carNamesInput = inputView.readCarNames();

        assertThat(carNamesInput).isEqualTo(input);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
