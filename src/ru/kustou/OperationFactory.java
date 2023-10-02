package ru.kustou;

class OperationFactory {
    public static IOperation getOperator(String value) {
        switch (value){
            case "+":
                return new Addition();

            case "-":
                return new Subtraction();

            case "/":
                return new Division();

            case "*":
                return new Multiplication();

            default:
                throw new RuntimeException("Строка не является математической операцией");
        }
    }
}
