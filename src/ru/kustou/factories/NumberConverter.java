package ru.kustou.factories;

import java.util.regex.Pattern;

public abstract class NumberConverter<Number> {
    protected String regularCorrect;

    public Number convertTo(String value) {
        if (!this.isCorrect(value)) throw new RuntimeException("Используются одновременно разные системы счисления\n");

        return this.create(value);
    }

    public Number convertTo(int value) {
        return this.create(value);
    }

    private boolean isCorrect(String value) {
        return Pattern.matches(this.regularCorrect, value);
    }

    protected abstract Number create(String value);

    protected abstract Number create(int value);
}
