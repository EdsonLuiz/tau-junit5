package junit5tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
public class ParameterizedTests_07 {
  
  @ParameterizedTest
  @MethodSource(value = "sourceString")
  void methodSource_String(String param1) {
    System.out.println("param1 = " + param1);
  }

  @ParameterizedTest
  @MethodSource(value = "sourceStringAsStrem")
  void methodSourceStringStream(String param1) {
    System.out.println("param1 - "+ param1);
  }

  List<String> sourceString() {
    return Arrays.asList("tomate", "cenoura", "beterraba");
  }

  Stream<String> sourceStringAsStrem() {
    return Stream.of("banana", "maçã", "pera");
  }
}
