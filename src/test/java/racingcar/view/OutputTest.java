package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class OutputTest extends NsTest {

    private final OutputView outputView = new OutputViewImpl();

    @Test
    void 자동차_이름_입력_안내_메시지_출력() {
        assertSimpleTest(() -> {
            outputView.requestCarNamesInput();
            assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        });
    }

    @Test
    void 이동_횟수_입력_안내_메시지_출력() {
        assertSimpleTest(() -> {
            outputView.requestMoveCountInput();
            assertThat(output()).isEqualTo("시도할 횟수는 몇 회인가요?");
        });
    }

    @Override
    protected void runMain() {

    }
}
