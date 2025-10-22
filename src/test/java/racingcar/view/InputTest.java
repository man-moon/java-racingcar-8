package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputTest extends NsTest {

    private final InputView inputView = new InputViewImpl();

    @AfterEach
    void after() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력() {
        String input = "pobi,woni";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String carNamesInput = inputView.readCarNames();

        assertThat(carNamesInput).isEqualTo(input);
    }

    @Test
    void 이동_횟수_입력() {
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String moveCountInput = inputView.readMoveCount();

        assertThat(moveCountInput).isEqualTo(input);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
