package ua.com.foxminded.integerdivision;

public class LongDivision {

    public String longDivisionMethod(int numerator, int denominator) {

        String result = new String();
        boolean notError = true;

        // исключения
        if (denominator == 0) {
            notError = false;
            result = "Denominator must be greater than zero and not equal to zero";
            return result;
        }

        if (numerator > 2147483647 || denominator > 2147483647) {
            notError = false;
            result = "Number is too large";
            return result;
        }
        if (numerator < 0 || denominator < 0) {
            notError = false;
            result = "Numerator and denominator must not be less than zero";
            return result;
        }
        if (numerator < denominator) {
            notError = false;
            result = "Denominator must not be greater than the numerator";
            return result;
        }

        if (notError = true) {

            int answer = numerator / denominator;
            String space = " ";
            String split = "-";

            ArrayOutOfNumber arrayNumerator = new ArrayOutOfNumber();
            int[] arrayNumeratorActing = arrayNumerator.arrayNumber(numerator);

            int numberOfDigitsInTheNumerator = arrayNumeratorActing.length;

            ArrayOutOfNumber arrayAnswer = new ArrayOutOfNumber();
            int[] arrayAnswerActing = arrayAnswer.arrayNumber(answer);
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
        }
        return result;
    }
}