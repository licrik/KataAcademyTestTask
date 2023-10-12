package ru.kustou;


import ru.kustou.numbers.converters.NumberConverter;
import ru.kustou.numbers.NumberConverterFactory;
import ru.kustou.operations.OperationFactory;
import ru.kustou.numbers.models.Number;
import ru.kustou.operations.elements.IOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int MAX_INPUT_VALUE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            System.out.println("Введите математическую оперцию или exit, для выхода");

            String line = reader.readLine();
            if (line.toLowerCase().contains("exit")) break;

            System.out.println(calc(line));
        }
    }

    public static String calc(String input) {
        String[] arguments = splitInputString(input);
        NumberConverter<Number> converter = NumberConverterFactory.getConverter(arguments[0]);

        List<Number> numbers = getNumbers(arguments, converter);
        List<IOperation> operations = getOperations(arguments);

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
            Number number = converter.convertTo(value[i]);

            if (number.getValue() > MAX_INPUT_VALUE) throw new RuntimeException("Значение не может быть больше " + MAX_INPUT_VALUE);

            numbers.add(number);
        }

        return numbers;
    }

    private static List<IOperation> getOperations(String[] value) {
        List<IOperation> operations = new ArrayList<>();

        for (int i = 1; i < value.length; i += 2) {
            operations.add(OperationFactory.getOperator(value[i]));
        }

        return operations;
    }
}
