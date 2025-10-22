package racingcar.converter;

import java.util.List;

public class InputConverterImpl implements InputConverter {
    @Override
    public List<String> getCarNames(String carNamesInput) {
        List<String> carNames = List.of(carNamesInput.split(","));

        if (hasDuplicateCarName(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    @Override
    public int getMoveCount(String moveCountInput) {
        int moveCount = Integer.parseInt(moveCountInput);

        if (isValidMoveCount(moveCount)) {
            return moveCount;
        }
        throw new IllegalArgumentException();
    }

    private boolean hasDuplicateCarName(List<String> carNames) {
        int uniqueCount = (int) carNames.stream()
                .distinct()
                .count();

        return carNames.size() > uniqueCount;
    }

    private boolean isValidMoveCount(int moveCount) {
        return moveCount >= 0;
    }
}
