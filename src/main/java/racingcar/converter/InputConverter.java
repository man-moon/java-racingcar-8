package racingcar.converter;

import java.util.List;

public class InputConverter {

    public List<String> getCarNames(String carNamesInput) {
        List<String> carNames = List.of(carNamesInput.split(","));

        if (allCarNamesValid(carNames)) {
            return carNames;
        }
        throw new IllegalArgumentException();
    }

    public int getMoveCount(String moveCountInput) {
        int moveCount = Integer.parseInt(moveCountInput);

        if (isValidMoveCount(moveCount)) {
            return moveCount;
        }
        throw new IllegalArgumentException();
    }

    private boolean allCarNamesValid(List<String> carNames) {
        return isValidCarNameLength(carNames) && hasDuplicateCarName(carNames);
    }

    private boolean isValidCarNameLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(name -> !name.isEmpty() && name.length() <= 5);
    }

    private boolean hasDuplicateCarName(List<String> carNames) {
        int uniqueCount = (int)carNames.stream()
                .distinct()
                .count();

        return carNames.size() == uniqueCount;
    }

    private boolean isValidMoveCount(int moveCount) {
        return moveCount >= 0;
    }
}
