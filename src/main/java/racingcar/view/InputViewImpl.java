package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    public String readCarNames() {
        return Console.readLine();
    }
}