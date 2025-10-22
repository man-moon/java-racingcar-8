package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.converter.InputConverterImpl;
import racingcar.util.RandomNumberGeneratorImpl;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {

        RacingGameController controller = new RacingGameController(
                new InputViewImpl(),
                new OutputViewImpl(),
                new InputConverterImpl(),
                new RandomNumberGeneratorImpl()
        );

        controller.run();
    }
}
