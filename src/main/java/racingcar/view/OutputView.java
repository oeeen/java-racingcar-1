package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void outputAllTryCarPosition(List<RoundResult> rounds) {
        System.out.println("\n실행 결과");
        for (RoundResult round : rounds) {
            outputCarPosition(round);
        }
    }

    private static void outputCarPosition(RoundResult round) {
        for (Car car : round.getRoundResult()) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void outputWinners(List<Car> winners) {
        List<String> winnersName = new ArrayList<>();

        for (Car car : winners) {
            winnersName.add(car.getName());
        }
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}
