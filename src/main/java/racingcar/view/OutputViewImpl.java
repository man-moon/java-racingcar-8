package racingcar.view;

public class OutputViewImpl implements OutputView {
    @Override
    public void requestCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void requestMoveCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
