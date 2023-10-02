package ru.kustou.operations.elements;

import ru.kustou.numbers.models.Number;

public class Subtraction implements IOperation {
    @Override
    public int action(Number first, Number second) {
        return first.getValue() - second.getValue();
    }
}
