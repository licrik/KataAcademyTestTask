package ru.kustou.operators;


import ru.kustou.numbers.Number;

public class Multiplication implements Operator {
    @Override
    public int action(Number first, Number second) {
        return first.getValue() * second.getValue();
    }
}
