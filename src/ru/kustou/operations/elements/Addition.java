package ru.kustou.operations.elements;


import ru.kustou.numbers.models.Number;

public class Addition implements IOperation {
    @Override
    public int action(Number first, Number second) {
        return first.getValue() + second.getValue();
    }
}
