package ru.kustou.operators;

import ru.kustou.numbers.Number;

public class Division implements Operator {
    @Override
    public int action(Number first, Number second) {
        if (second.getValue() == 0) throw new RuntimeException("Деление на 0");

        return first.getValue() / second.getValue();
    }
}
