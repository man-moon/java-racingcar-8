package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.requestCarNamesInput();
        String carNamesInput = inputView.readCarNames();
        outputView.requestMoveCountInput();
        String moveCountInput = inputView.readMoveCount();
    }
}
