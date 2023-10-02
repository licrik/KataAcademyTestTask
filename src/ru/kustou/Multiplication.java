package ru.kustou;


class Multiplication implements IOperation {
    @Override
    public int action(Number first, Number second) {
        return first.getValue() * second.getValue();
    }
}
