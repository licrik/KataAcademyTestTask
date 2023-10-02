package ru.kustou;


class Addition implements IOperation {
    @Override
    public int action(Number first, Number second) {
        return first.getValue() + second.getValue();
    }
}
