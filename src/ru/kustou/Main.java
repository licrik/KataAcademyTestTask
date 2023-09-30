package ru.kustou;


import ru.kustou.factories.NumberConverter;
import ru.kustou.factories.OperationConverter;
import ru.kustou.factories.OperatorFactory;
import ru.kustou.numbers.Number;
import ru.kustou.operators.Operator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(calc("0 / 2"));
        System.out.println(calc("1 / 2"));
        System.out.println(calc("VI / III"));
        //System.out.println(calc("I - II"));
        //System.out.println(calc("I + 1"));
        //System.out.println(calc("1"));
        //System.out.println(calc("1 + 2 + 3"));
    }

    public static String calc(String input) {
        String[] arguments = splitInputString(input);
        NumberConverter<Number> converter = OperationConverter.getConverter(arguments[0]);

        List<Number> numbers = getNumbers(arguments, converter);
        List<Operator> operations = getOperations(arguments);

        int result = 0;

        for (int i = 0; i < operations.size(); i++) {
            result += operations.get(i).action(numbers.get(i * 2), numbers.get(i * 2 + 1));
        }

        return converter.convertTo(result).toString();
    }

    private static String[] splitInputString(String input) {
        String[] arguments = input.split(" ");

        if (arguments.length != 3) throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        return arguments;
    }

    private static List<Number> getNumbers(String[] value, NumberConverter<Number> converter) {
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < value.length; i +=2) {
            numbers.add(converter.convertTo(value[i]));
        }

        return numbers;
    }

    private static List<Operator> getOperations(String[] value) {
        List<Operator> operations = new ArrayList<>();

        for (int i = 1; i < value.length; i += 2) {
            operations.add(OperatorFactory.getOperator(value[i]));
        }

        return operations;
    }
}
