package racingcar.model;

import java.util.List;

public class Car {
    private final String name;
    private int pos = 0;

    public void tryMove(int number) {
        if (number >= 4) {
            move();
        }
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    public Car(String name) {
        if(!isValidNameLength(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private void move() {
        pos++;
    }

    private boolean isValidNameLength(String name) {
        return !name.isEmpty() && name.length() <= 5;
    }
}
