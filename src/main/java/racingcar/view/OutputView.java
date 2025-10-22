package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public interface OutputView {
    void requestCarNamesInput();
    void requestMoveCountInput();
    void printRaceStatus(List<Car> cars, int currentRound);
    void printRaceResult(List<Car> winners);
}