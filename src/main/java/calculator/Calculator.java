package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Calculator {
    private static Map<String, Operator> operatorMap = new HashMap<>();

    static {
        operatorMap.put("+", Operator.PLUS);
        operatorMap.put("-", Operator.MINUS);
        operatorMap.put("*", Operator.MULTIPLY);
        operatorMap.put("/", Operator.DIVIDE);
    }

//    double calculate(double a, String operator, double b) {
//        return Optional.ofNullable(operatorMap.get(operator))
//                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입력입니다."))
//                .mapCalculate(a, b);
//    }

    double calculate(double a, String operator, double b) {
        return Operator.calculate(operator, a, b);
    }

    double calculateAll(String[] inputs) {
        if (inputs.length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        double result = Double.parseDouble(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            result = calculate(result, inputs[i], Double.parseDouble(inputs[i + 1]));
        }
        return result;
    }
}
