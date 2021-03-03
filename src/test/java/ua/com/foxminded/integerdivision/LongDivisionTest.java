package ua.com.foxminded.integerdivision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongDivisionTest {

    LongDivision startvaluesforlongdivision;

    @BeforeEach
    public void newobjectforreverse() {
        startvaluesforlongdivision = new LongDivision();
    }

    @Test
    @DisplayName("Numerator less than zero")
    void longDivisionMethodShouldReturnFalseWhenNumeratorLessThanZero() {
        assertEquals ("Numerator and denominator must not be less than zero",startvaluesforlongdivision.longDivisionMethod(-2,12));
    }

    @Test
    @DisplayName("Denominator less than zero")
    void longDivisionMethodShouldReturnFalseWhenDenominatorLessThanZero() {
        assertEquals ("Numerator and denominator must not be less than zero",startvaluesforlongdivision.longDivisionMethod(12,-2));
    }

    @Test
    @DisplayName("Division by zero")
    void longDivisionMethodShouldReturnFalseWhenDevisionByZero() {
        assertEquals ("Denominator must be greater than zero and not equal to zero",startvaluesforlongdivision.longDivisionMethod(122,0));
    }

    @Test
    @DisplayName("Denominator is greater than the numerator")
    void longdivisiontoconsoleShouldReturnFalseWhenDenominatorIsGreaterThanNumerator() {
        assertEquals ("Denominator must not be greater than the numerator",startvaluesforlongdivision.longDivisionMethod(12,4444));
    }
    @Test
    @DisplayName("check for correct")
    void longDivisionMethodCheckForCorrect() {
        assertEquals ("_123|1\n 1  |-----\n -  |123\n_2\n 2\n --\n _3\n  3\n  --\n   0",startvaluesforlongdivision.longDivisionMethod(123,1));
    }

}