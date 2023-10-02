package ru.kustou;

class ArabicConverter extends NumberConverter<ArabicNumber> {

    public ArabicConverter() {
        this.regularCorrect = "[0-9]+";
    }

    @Override
    protected ArabicNumber create(String value) {
        ArabicNumber number = new ArabicNumber();

        number.setValue(this.convertToInt(value));

        return number;
    }

    @Override
    protected ArabicNumber create(int value) {
        ArabicNumber number = new ArabicNumber();

        number.setValue(value);

        return number;
    }

    private int convertToInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException  ex) {
            throw new RuntimeException("Введенная цифра не относиться к арабскому афавиту");
        }
    }
}
