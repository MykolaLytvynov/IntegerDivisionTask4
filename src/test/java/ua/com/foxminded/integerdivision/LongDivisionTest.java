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
        assertThrows(IllegalArgumentException.class, () -> startvaluesforlongdivision.longDivisionMethod(-2, 12));
    }

    @Test
    @DisplayName("Denominator less than zero")
    void longDivisionMethodShouldReturnFalseWhenDenominatorLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> startvaluesforlongdivision.longDivisionMethod(12, -2));
    }

    @Test
    @DisplayName("Division by zero")
    void longDivisionMethodShouldReturnFalseWhenDevisionByZero() {
        assertThrows(ArithmeticException.class, () -> startvaluesforlongdivision.longDivisionMethod(122, 0));
    }

    @Test
    @DisplayName("Denominator is greater than the numerator")
    void longdivisiontoconsoleShouldReturnFalseWhenDenominatorIsGreaterThanNumerator() {
        assertThrows(IllegalArgumentException.class, () -> startvaluesforlongdivision.longDivisionMethod(12, 4444));
    }

    @Test
    @DisplayName("check for correct")
    void longDivisionMethodCheckForCorrect() {
        assertEquals("_123|1\n 1  |-----\n -  |123\n_2\n 2\n --\n _3\n  3\n  --\n   0", startvaluesforlongdivision.longDivisionMethod(123, 1));
    }

}