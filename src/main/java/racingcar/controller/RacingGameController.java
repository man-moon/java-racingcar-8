package racingcar.controller;

import java.util.List;
import racingcar.converter.InputConverter;
import racingcar.converter.InputConverterImpl;
import racingcar.model.Car;
import racingcar.model.CarRace;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputConverter converter;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGameController(InputView inputView, OutputView outputView,
                                InputConverter converter, RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.converter = converter;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        outputView.requestCarNamesInput();
        String carNamesInput = inputView.readCarNames();
        outputView.requestMoveCountInput();
        String moveCountInput = inputView.readMoveCount();

        List<String> carNames = converter.getCarNames(carNamesInput);
        int moveCount = converter.getMoveCount(moveCountInput);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        CarRace carRace = new CarRace(moveCount, cars, randomNumberGenerator, outputView);

        carRace.start();
    }
}