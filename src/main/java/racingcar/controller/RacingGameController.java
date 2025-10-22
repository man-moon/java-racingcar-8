package racingcar.controller;

import java.util.List;
import racingcar.converter.InputConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputConverter converter;

    public RacingGameController(InputView inputView, OutputView outputView, InputConverter converter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.converter = converter;
    }

    public void run() {
        outputView.requestCarNamesInput();
        String carNamesInput = inputView.readCarNames();
        outputView.requestMoveCountInput();
        String moveCountInput = inputView.readMoveCount();

        List<String> carNames = converter.getCarNames(carNamesInput);
        int moveCount = converter.getMoveCount(moveCountInput);
    }
}
