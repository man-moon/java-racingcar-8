package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.converter.InputConverter;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {

        RacingGameController controller = new RacingGameController(
                new InputViewImpl(),
                new OutputViewImpl(),
                new InputConverter()
        );

        controller.run();
    }
}
