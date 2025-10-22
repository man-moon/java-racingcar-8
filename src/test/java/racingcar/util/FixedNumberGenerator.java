package racingcar.util;

public class FixedNumberGenerator implements RandomNumberGenerator {
    private final int number;

    @Override
    public int generate() {
        return number;
    }

    public FixedNumberGenerator(int number) {
        this.number = number;
    }
}
