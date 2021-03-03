package ua.com.foxminded.integerdivision;

public class ArrayOutOfNumber {
    public int[] arraynumber (int numberforaaray) {

        int kolychestvoarray = Integer.toString(numberforaaray).length();
        int[] myArray  = new int[kolychestvoarray];
        for (int i = myArray .length - 1; i > 0; i--) {
            myArray [i] = numberforaaray % 10;
            numberforaaray /= 10;
        }
        myArray [0] = numberforaaray * 1;
        return myArray;
    }
}
