package racingcar.controller;

import java.util.List;
import racingcar.converter.InputConverter;
import racingcar.model.Car;
import racingcar.model.CarRace;
import racingcar.model.CarRace.RoundResult;
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
        List<String> carNames = getCarNamesFromUser();
        int moveCount = getMoveCountFromUser();
        List<Car> cars = createCars(carNames);

        CarRace carRace = new CarRace(moveCount, cars, randomNumberGenerator);
        runRace(carRace);
    }

    private List<String> getCarNamesFromUser() {
        outputView.requestCarNamesInput();
        String carNamesInput = inputView.readCarNames();
        return converter.getCarNames(carNamesInput);
    }

    private int getMoveCountFromUser() {
        outputView.requestMoveCountInput();
        String moveCountInput = inputView.readMoveCount();
        return converter.getMoveCount(moveCountInput);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void runRace(CarRace carRace) {
        List<RoundResult> results = carRace.start();

        results.forEach(result ->
                outputView.printRaceStatus(result.cars(), result.round()));
        outputView.printRaceResult(carRace.getWinners());
    }
}