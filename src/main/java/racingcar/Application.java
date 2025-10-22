package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {

        RacingGameController controller = new RacingGameController(
                new InputViewImpl(), new OutputViewImpl()
        );

        controller.run();
    }
}
