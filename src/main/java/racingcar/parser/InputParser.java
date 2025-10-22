package racingcar.parser;

import java.util.List;

public class InputParser {

    public List<String> parse(String input) {
        List<String> carNames = List.of(input.split(","));

        if (allCarNamesValid(carNames)) {
            return carNames;
        }
        throw new IllegalArgumentException();
    }

    private boolean allCarNamesValid(List<String> carNames) {
        return carNames.stream()
                .allMatch(this::isValidName);
    }

    private boolean isValidName(String name) {
        return !name.isEmpty() && name.length() <= 5;
    }
}
