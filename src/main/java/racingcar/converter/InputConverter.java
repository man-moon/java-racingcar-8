package racingcar.converter;

import java.util.List;

public interface InputConverter {
    List<String> getCarNames(String carNamesInput);

    int getMoveCount(String moveCountInput);
}
