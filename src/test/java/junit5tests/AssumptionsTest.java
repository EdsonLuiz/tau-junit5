package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {

    @ParameterizedTest(name = "Should receive the value {arguments}")
    @ValueSource(ints = {1, 2, 5})
    void intValuesAssumeTrue(int param1) {
        assumeTrue(param1 > 4);
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest(name = "Should receive the value {arguments}")
    @ValueSource(strings = {"edson", "luiz", "ribeiro"})
    void stringValuesAssumeFalseWithMessage(String param1) {
        assumeFalse(param1.equals("edson"),
                "The assumption failed for the following param "+ param1);
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest(name = "Should receive the value {arguments}")
    @ValueSource(ints = {10, 20, 30, 40})
    void intValuesAssumeThat(int param1) {
        assumingThat(param1 < 20, () -> System.out.println("Code run"));
        System.out.println("param1 = " + param1);
    }
}
