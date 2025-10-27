package racingcar.converter;

import java.util.Arrays;
import java.util.List;

public class InputConverterImpl implements InputConverter {
    @Override
    public List<String> getCarNames(String carNamesInput) {
        List<String> carNames = Arrays.stream(carNamesInput.split(",", -1))
                .map(String::trim)
                .toList();

        if (hasDuplicateCarName(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    @Override
    public int getMoveCount(String moveCountInput) {
        try {
            int moveCount = Integer.parseInt(moveCountInput);
            validateMoveCount(moveCount);
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateCarName(List<String> carNames) {
        return carNames.size() != carNames.stream()
                .distinct()
                .count();
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("이동 횟수는 0 이상이어야 합니다.");
        }
    }
}
