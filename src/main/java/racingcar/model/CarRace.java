package racingcar.model;

import java.util.List;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class CarRace {
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    private final List<Car> cars;
    private final int lastRound;
    private int currentRound = 0;

    public CarRace(int lastRound, List<Car> cars, RandomNumberGenerator randomNumberGenerator, OutputView outputView) {
        this.lastRound = lastRound;
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
        this.outputView = outputView;
    }

    public void start() {
        while (currentRound < lastRound) {
            runSingleRound();
            currentRound++;
        }
        List<Car> winners = findWinners();
    }

    private void runSingleRound() {
        cars.forEach(car -> {
            int randomNumber = randomNumberGenerator.generate();
            car.tryMove(randomNumber);
        });
    }

    private List<Car> findWinners() {
        int maxPos = cars.stream()
                .mapToInt(Car::getPos)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPos() == maxPos)
                .toList();
    }
}
