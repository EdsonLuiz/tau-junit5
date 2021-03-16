package book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CarTest {

    private Car myFerrari = mock(Car.class);

    @Test
    @DisplayName("Car should be instance of Car")
    void testIfCarIsCar() {
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    void testDefaultBehaviourOfTestDouble() {
        assertFalse(myFerrari.needsFuel(),"new Test double should return false as boolean");
        assertEquals(0.0, myFerrari.getEngineTemperature(), "new test double should return 0.0 as double");

    }
}