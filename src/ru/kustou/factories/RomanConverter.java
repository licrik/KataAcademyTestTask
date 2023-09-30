package ru.kustou.factories;

import ru.kustou.numbers.RomanNumber;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter extends NumberConverter<RomanNumber> {

    public RomanConverter() {
        this.regularCorrect = "[I-X]+";
    }

    @Override
    protected RomanNumber create(String value) {
        RomanNumber number = new RomanNumber();

        number.setValue(this.convertToInt(value));

        return number;
    }

    @Override
    protected RomanNumber create(int value) {
        RomanNumber number = new RomanNumber();

        number.setValue(value);

        return number;
    }

    private int convertToInt(String stringNumber) {
        int number = 0;
        Map<Character, Integer> map=new HashMap<Character, Integer>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        stringNumber = stringNumber.replace("IV","IIII");
        stringNumber = stringNumber.replace("IX","VIIII");
        stringNumber = stringNumber.replace("XL","XXXX");
        stringNumber = stringNumber.replace("XC","LXXXX");
        stringNumber = stringNumber.replace("CD","CCCC");
        stringNumber = stringNumber.replace("CM","DCCCC");

        for (int i = 0; i < stringNumber.length(); i++)
        {
            number = number + (map.get(stringNumber.charAt(i)));
        }

        return number;
    }
}
