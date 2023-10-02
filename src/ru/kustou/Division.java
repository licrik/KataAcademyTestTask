package ru.kustou;

class Division implements IOperation {
    @Override
    public int action(Number first, Number second) {
        if (second.getValue() == 0) throw new RuntimeException("Деление на 0");

        return first.getValue() / second.getValue();
    }
}
