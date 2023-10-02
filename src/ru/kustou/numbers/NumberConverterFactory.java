package ru.kustou.numbers;

import ru.kustou.numbers.converters.ArabicConverter;
import ru.kustou.numbers.converters.NumberConverter;
import ru.kustou.numbers.converters.RomanConverter;

import java.util.regex.Pattern;

public class NumberConverterFactory {

    public static NumberConverter getConverter(String value) {
        if (isRoman(value)) {
            return new RomanConverter();
        }
        if (isArabic(value)) {
            return new ArabicConverter();
        }

        throw new RuntimeException("Данное число не поддерживается");
    }

    private static boolean isRoman(String value) {
        return Pattern.matches("[I-X]+", value);
    }

    private static boolean isArabic(String value) {
        return Pattern.matches("[0-9]+", value);
    }
}
