package ua.com.foxminded.integerdivision;

public class LongDivision {


    private void header(int numerator, int denominator, int numberofdigitsinthenumerator) {

        int answer = numerator / denominator;
        String space = " ";
        String split = "-";

        ArrayOutOfNumber arrayanswer = new ArrayOutOfNumber();
        int[] arrayansweracting = arrayanswer.arraynumber(answer);
        int subtractednumber = arrayansweracting[0] * denominator;

        String spacesforplashka = space.repeat(numberofdigitsinthenumerator - String.valueOf(subtractednumber).length());

        System.out.println("_" + numerator + "|" + denominator);
        System.out.println(" " + subtractednumber + spacesforplashka + "|-----");
        System.out.println(" " + split.repeat(String.valueOf(subtractednumber).length()) + spacesforplashka + "|" + answer);
    }

    public boolean longdivisiontoconsole(int numerator, int denominator) {

        boolean noterror = true;

        // исключения
        if (denominator == 0) {
            noterror = false;
            System.out.println("Denominator must be greater than zero and not equal to zero");
            return noterror;
        }

        if (numerator > 2147483647 || denominator > 2147483647) {
            noterror = false;
            System.out.println("Number is too large");
            return noterror;
        }
        if (numerator < 0 || denominator < 0) {
            noterror = false;
            System.out.println("Numerator and denominator must not be less than zero");
            return noterror;
        }
        if (numerator < denominator) {
            noterror = false;
            System.out.println("Denominator must not be greater than the numerator");
            return noterror;
        }

        if (noterror = true) {

            ArrayOutOfNumber arraynumerator = new ArrayOutOfNumber();
            int[] arraynumeratoracting = arraynumerator.arraynumber(numerator);

            String space = " ";
            String split = "-";

            int numberofdigitsinthenumerator = arraynumeratoracting.length;
            LongDivision outputinheader = new LongDivision();
            outputinheader.header(numerator, denominator, numberofdigitsinthenumerator);

            int subtractednumber = 0;
            int decreasednumber = arraynumeratoracting[0];
            int g = 0;
            int numberofcycles = 0;

            while (g < (arraynumeratoracting.length - 1)) {

                String spacesforcycle = space.repeat(g + 1 - String.valueOf(decreasednumber).length());

                while (decreasednumber < denominator) {
                    g++;
                    if (g == arraynumeratoracting.length) {
                        break;
                    }
                    if (decreasednumber == 0) {
                        decreasednumber = arraynumeratoracting[g];
                        break;
                    }
                    decreasednumber = Integer.valueOf(String.valueOf(decreasednumber) + String.valueOf(arraynumeratoracting[g]));
                }

                if (numberofcycles > 0) {
                    System.out.println(spacesforcycle + "_" + decreasednumber);
                }

                int degree = Math.round(decreasednumber / denominator);
                subtractednumber = denominator * degree;
                decreasednumber = decreasednumber - (subtractednumber);

                if (numberofcycles > 0) {
                    System.out.println(spacesforcycle + " " + (subtractednumber));
                    System.out.println(spacesforcycle + " " + split.repeat(String.valueOf(decreasednumber).length() + 1));
                }
                if (g == (arraynumeratoracting.length - 1)) {
                    System.out.println(spacesforcycle + "  " + decreasednumber);
                }
                numberofcycles++;
            }
        }
        return noterror;
    }
}