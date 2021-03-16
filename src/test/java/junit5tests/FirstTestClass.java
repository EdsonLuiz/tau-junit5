package junit5tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass {
    public static int count =  0;

    @BeforeEach
    void beforeEach() {
        count ++;
        System.out.println("==== beforeEach");
    }

    @AfterEach
    void afterEach() {
        count ++;
        System.out.println("==== afterEach");
    }

    @Test
    void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("Test the second method")
    void secondMethod() {
        System.out.println("This is the second test method");
        System.out.println(count);
    }
}
