package ua.com.foxminded.integerdivision;

public class LongDivision {
    String space = " ";
    String split = "-";

    public String longDivisionMethod(int numerator, int denominator) {

        String result = new String();
        checkForExceptions(numerator, denominator);

        int answer = numerator / denominator;

        int[] arrayNumeratorActing = MakeArrayOutOfNumber(numerator);
        int numberOfDigitsInTheNumerator = arrayNumeratorActing.length;

        int[] arrayAnswerActing = MakeArrayOutOfNumber(answer);
        int subtractedNumber = arrayAnswerActing[0] * denominator;

        String spacesForPlashka = space.repeat(numberOfDigitsInTheNumerator - String.valueOf(subtractedNumber).length());

        result = "_" + numerator + "|" + denominator + "\n";
        result += " " + subtractedNumber + spacesForPlashka + "|-----" + "\n";
        result += " " + split.repeat(String.valueOf(subtractedNumber).length()) + spacesForPlashka + "|" + answer + "\n";

        int decreasedNumber = arrayNumeratorActing[0];
        int g = 0;
        int numberOfCycles = 0;

        while (g < (arrayNumeratorActing.length - 1)) {

            String spacesForCycle = space.repeat(g + 1 - String.valueOf(decreasedNumber).length());

            while (decreasedNumber < denominator) {
                g++;
                if (g == arrayNumeratorActing.length) {
                    break;
                }
                if (decreasedNumber == 0) {
                    decreasedNumber = arrayNumeratorActing[g];
                    break;
                }
                decreasedNumber = Integer.valueOf(String.valueOf(decreasedNumber) + String.valueOf(arrayNumeratorActing[g]));
            }

            if (numberOfCycles > 0) {
                result += spacesForCycle + "_" + decreasedNumber + "\n";
            }

            int degree = Math.round(decreasedNumber / denominator);
            subtractedNumber = denominator * degree;
            decreasedNumber = decreasedNumber - (subtractedNumber);

            if (numberOfCycles > 0) {
                result += spacesForCycle + " " + (subtractedNumber) + "\n";
                result += spacesForCycle + " " + split.repeat(String.valueOf(decreasedNumber).length() + 1) + "\n";
            }
            if (g == (arrayNumeratorActing.length - 1)) {
                result += spacesForCycle + "  " + decreasedNumber;
            }
            numberOfCycles++;
        }
        return result;
    }

    private int[] MakeArrayOutOfNumber(int numberForArray) {
        int arraySize = Integer.toString(numberForArray).length();
        int[] myArray = new int[arraySize];
        for (int i = myArray.length - 1; i > 0; i--) {
            myArray[i] = numberForArray % 10;
            numberForArray /= 10;
        }
        myArray[0] = numberForArray * 1;
        return myArray;
    }

    private void checkForExceptions(int numerator, int denominator) {
        // исключения
        if (denominator == 0) {
            throw new ArithmeticException("Denominator must be greater than zero and not equal to zero");
        }
        if (numerator < 0 || denominator < 0) {
            throw new IllegalArgumentException("Numerator and denominator must not be less than zero");
        }
        if (numerator < denominator) {
            throw new IllegalArgumentException("Denominator must not be greater than the numerator");
        }
    }
}