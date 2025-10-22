package racingcar.controller;

import java.util.List;
import racingcar.parser.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public RacingGameController(InputView inputView, OutputView outputView, InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void run() {
        outputView.requestCarNamesInput();
        String carNamesInput = inputView.readCarNames();
        outputView.requestMoveCountInput();
        String moveCountInput = inputView.readMoveCount();

        List<String> carNames = inputParser.parse(carNamesInput);
    }
}
