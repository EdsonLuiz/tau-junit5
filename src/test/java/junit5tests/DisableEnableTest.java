package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class DisableEnableTest {

    @Test
    @Disabled(value = "Disabled for demo purposes")
    void test01() {
        System.out.println("Test 01");
    }

    @Test
    @DisabledOnOs(value = OS.MAC, disabledReason = "Disabled for demo purposes only on MAC")
    void test02() {
        System.out.println("Test 02");
    }

    @Test
    @DisabledIfSystemProperty(named = "env",
            matches = "staging", disabledReason = "Disabled based on system property")
    void test03() {
        System.out.println("Test 03");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled based on method returned boolean")
    void test04() {
        System.out.println("Test 04");
    }

    @Test
    void test05() {
        System.out.println("Test 05");
    }

    boolean provider() {
        return true;
    }
}
