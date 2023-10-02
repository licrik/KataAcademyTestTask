package ru.kustou.operations.elements;

import ru.kustou.numbers.models.Number;

public class Division implements IOperation {
    @Override
    public int action(Number first, Number second) {
        if (second.getValue() == 0) throw new RuntimeException("Деление на 0");

        return first.getValue() / second.getValue();
    }
}
