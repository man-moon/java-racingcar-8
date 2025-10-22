package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class OutputTest extends NsTest {

    private final String carNameInputPrompt = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final OutputView outputView = new OutputViewImpl();

    @Test
    void 자동차_이름_입력_안내_메시지_출력_테스트() {
        assertSimpleTest(() -> {
            outputView.requestInputCarNames();
            assertThat(output()).isEqualTo(carNameInputPrompt);
        });
    }

    @Override
    protected void runMain() {

    }
}
