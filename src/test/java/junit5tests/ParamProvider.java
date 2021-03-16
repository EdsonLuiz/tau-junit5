package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {

    /**
     * To be used as method source the external method need to be
     * marked as static
     *
     */
    static Stream<Arguments> sourceStream_StringDoubleFromExternalClass() {
        return Stream.of(
                arguments("maçã", 2.3),
                arguments("pera", 1.2)
        );
    }
}
