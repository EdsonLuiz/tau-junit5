package book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoReturningDesiredValuesTest {

    private Car myFerrari = mock(Car.class);

    @Test
    void testStubbing() {
        assertFalse(myFerrari.needsFuel());
        when(myFerrari.needsFuel()).thenReturn(true);
        assertTrue(myFerrari.needsFuel());
    }
}
