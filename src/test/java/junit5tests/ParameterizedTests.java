package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {10, 20, 30})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString", "SecondString"})
    void stringValues(String theParams) {
        System.out.println("theParams = " + theParams);
    }

    @ParameterizedTest
    @CsvFileSource(
            files = "src/test/resources/params/shoppinglist.csv",
            numLinesToSkip = 1
    )
    void csvFileSource_StringDoubleIntStringString(
            String name,
            double price,
            int qty,
            String uom,
            String provider
    ) {
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1) {
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString() {
        // don't forget to add
        // @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        // to avoid make this method static
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StreamOfStrings(String param1) {
        System.out.println("param1 = " + param1);
    }

    Stream<String> sourceStringAsStream() {
        return Stream.of("beetroot", "apple", "pear");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void mehodSource_ListOfStringAndDouble(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<Arguments> sourceList_StringDouble() {
        return Arrays.asList(
                arguments("tomato", 2.0),
                arguments("apple", 12.0),
                arguments("pear", 245.7)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStream_StringDouble")
    void mehodSource_StreamOfStringAndDouble(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    Stream<Arguments> sourceStream_StringDouble() {
        return Stream.of(
                arguments("morango", 1.0),
                arguments("uva", 3.0),
                arguments("cenoura", 9.0));
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDoubleFromExternalClass")
    void methodSource_ExternalStreamOfStringAdnDouble(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
}
