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
    void longdivisiontoconsoleShouldReturnFalseWhenNumeratorLessThanZero() {
        assertEquals (false,startvaluesforlongdivision.longdivisiontoconsole(-2,12));
    }

    @Test
    @DisplayName("Denominator less than zero")
        void longdivisiontoconsoleShouldReturnFalseWhenDenominatorLessThanZero() {
            assertEquals (false,startvaluesforlongdivision.longdivisiontoconsole(12,-2));
    }

    @Test
    @DisplayName("Division by zero")
    void longdivisiontoconsoleShouldReturnFalseWhenDevisionByZero() {
        assertEquals (false,startvaluesforlongdivision.longdivisiontoconsole(122,0));
    }

    @Test
    @DisplayName("Denominator is greater than the numerator")
    void longdivisiontoconsoleShouldReturnFalseWhenDenominatorIsGreaterThanNumerator() {
        assertEquals (false,startvaluesforlongdivision.longdivisiontoconsole(12,4444));
    }


}