package ua.com.foxminded.integerdivision;

public class Calculator {
    public static void main(String[] args) {

        LongDivision example = new LongDivision();
        String exampleForConsole = example.longDivisionMethod(123, 11);
        System.out.print(exampleForConsole);

    }
}