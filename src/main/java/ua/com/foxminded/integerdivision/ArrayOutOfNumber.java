package ua.com.foxminded.integerdivision;

public class ArrayOutOfNumber {
    public int[] arrayNumber(int numberForArray) {

        int arraySize = Integer.toString(numberForArray).length();
        int[] myArray  = new int[arraySize];
        for (int i = myArray .length - 1; i > 0; i--) {
            myArray [i] = numberForArray % 10;
            numberForArray /= 10;
        }
        myArray [0] = numberForArray * 1;
        return myArray;
    }
}
