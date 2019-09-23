package org.erhmutlu.kata;

import java.util.*;
import java.util.function.BiFunction;

public class PostfixCalculator {

    private static final List<String> availableOperands = Arrays.asList("+", "-", "*", "/");

    private static Map<String, BiFunction<Double, Double, Double>> operatorMappings = new HashMap<>();

    static {
        operatorMappings.put("+", add());
        operatorMappings.put("-", subtract());
        operatorMappings.put("*", multiply());
        operatorMappings.put("/", divide());
    }


    public double evaluate(String expr) {
        if (isBlank(expr)){
            return 0;
        }

        List<String> operatorsAndOperands = Arrays.asList(expr.split(" "));
        return calculate(operatorsAndOperands);
    }

    private double calculate(List<String> operatorsAndOperands){
        Stack<Double> doubleStack = new Stack<>();
        operatorsAndOperands
                .forEach(item -> {
                    if (isNotOperand(item)) {
                        doubleStack.push(new Double(item));
                    } else {
                        Double d1 = doubleStack.pop();
                        Double d2 = doubleStack.pop();

                        Double result = operatorMappings.get(item).apply(d2, d1);
                        doubleStack.push(result);
                    }
                });
        return doubleStack.pop();
    }

    private boolean isBlank(String expr){
        return expr == null || expr.trim().length() == 0;
    }

    private boolean isOperand(String item) {
        return availableOperands.contains(item);
    }

    private boolean isNotOperand(String item) {
        return !isOperand(item);
    }

    private static BiFunction<Double, Double, Double> add() {
        return (d1, d2) -> d1 + d2;
    }

    private static BiFunction<Double, Double, Double> subtract() {
        return (d1, d2) -> d1 - d2;
    }

    private static BiFunction<Double, Double, Double> multiply() {
        return (d1, d2) -> d1 * d2;
    }

    private static BiFunction<Double, Double, Double> divide() {
        return (d1, d2) -> d1 / d2;
    }
    public static void main(String[] args) {
        PostfixCalculator postfixCalculator = new PostfixCalculator();
        System.out.println(postfixCalculator.evaluate("4 2 /"));
    }
}
