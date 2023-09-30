package ru.kustou.numbers;

public class RomanNumber extends Number {
    @Override
    public void setValue(int value) {
        if (value > 0) {
            super.setValue(value);
        } else {
            throw new RuntimeException("В римской системе нет чисел");
        }
    }

    @Override
    public String toString() {
        return intToRoman(this.value);
    }

    private String intToRoman(int num) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }

        return roman.toString();
    }
}
