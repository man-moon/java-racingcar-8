package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String readCarNames() {
        return Console.readLine();
    }

    @Override
    public String readMoveCount() {
        return Console.readLine();
    }
}