package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarRaceTest extends NsTest {
    private static final int MOVE = 4;
    private static final int STOP = 3;

    @Test
    void 경주_테스트_1() {
        assertRandomNumberInRangeTest(() -> {
                    run("AAA,BBB,CCC,DDD", "5");
                    assertThat(output()).contains(
                            "AAA : ----", "BBB : -", "CCC : ---", "DDD : -----", "최종 우승자 : DDD"
                    );
                },
                MOVE, STOP, MOVE, MOVE,
                MOVE, MOVE, MOVE, MOVE,
                MOVE, STOP, STOP, MOVE,
                MOVE, STOP, MOVE, MOVE,
                STOP, STOP, STOP, MOVE
        );
    }

    @Test
    void 경주_테스트_2() {
        assertRandomNumberInRangeTest(() -> {
                    run("AAA,BBB,CCC,DDD", "2");
                    assertThat(output()).contains(
                            "AAA : ", "BBB : ", "CCC : ", "DDD : ", "최종 우승자 : AAA, BBB, CCC, DDD"
                    );
                },
                STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 경주_혼자_참여() {
        assertRandomNumberInRangeTest(() -> {
                    run("AAA", "5");
                    assertThat(output()).contains(
                            "AAA : ---", "최종 우승자 : AAA"
                    );
                },
                MOVE, STOP, STOP, MOVE, MOVE
        );
    }

    @Test
    void 경주_시도_횟수_0번인_경우_최종_우승자만_출력_단일() {
        assertRandomNumberInRangeTest(() -> {
                    run("AAA", "0");
                    assertThat(output()).contains(
                            "최종 우승자 : AAA"
                    );
                },
                MOVE, STOP, STOP, MOVE, MOVE
        );
    }

    @Test
    void 경주_시도_횟수_0번인_경우_최종_우승자만_출력_다중() {
        assertRandomNumberInRangeTest(() -> {
                    run("AAA,BBB,CCC", "0");
                    assertThat(output()).contains(
                            "최종 우승자 : AAA, BBB, CCC"
                    );
                },
                MOVE, STOP, STOP, MOVE, MOVE
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
