package book;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class MockitoThrowingExceptionsTest {
    private Car myFerrai = mock(Car.class);

    @Test()
    void throwException() {
        when(myFerrai.needsFuel())
                .thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, myFerrai::needsFuel);
    }
}
