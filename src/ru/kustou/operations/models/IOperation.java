package ru.kustou.operations.models;

import ru.kustou.numbers.models.Number;

public interface IOperation {
    int action(Number first, Number second);
}
