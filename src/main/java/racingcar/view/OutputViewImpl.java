package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputViewImpl implements OutputView {
    @Override
    public void requestCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void requestMoveCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void printRaceStatus(List<Car> cars, int currentRound) {
        if (currentRound == 0) {
            System.out.println("실행 결과");
        }
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> appendCarStatus(sb, car));

        System.out.println(sb);
    }

    @Override
    public void printRaceResult(List<Car> winners) {
        System.out.print("최종 우승자 : ");

        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        String result = String.join(", ", winnerNames);

        System.out.println(result);
    }

    private void appendCarStatus(StringBuilder sb, Car car) {
        sb.append(car.getName())
                .append(" : ")
                .append("-".repeat(car.getPos()))
                .append("\n");
    }
}
