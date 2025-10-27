package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class CarRace {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Car> cars;
    private final int totalRounds;

    public CarRace(int lastRound, List<Car> cars, RandomNumberGenerator randomNumberGenerator) {
        this.totalRounds = lastRound;
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<RoundResult> start() {
        List<RoundResult> results = new ArrayList<>();

        for (int round = 1; round <= totalRounds; round++) {
            runSingleRound();
            results.add(new RoundResult(round, List.copyOf(cars)));
        }

        return results;
    }

    public List<Car> getWinners() {
        int maxPos = cars.stream()
                .mapToInt(Car::getPos)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPos() == maxPos)
                .toList();
    }

    private void runSingleRound() {
        cars.forEach(car -> {
            int randomNumber = randomNumberGenerator.generate();
            car.tryMove(randomNumber);
        });
    }

    public record RoundResult(int round, List<Car> cars) {
    }
}
