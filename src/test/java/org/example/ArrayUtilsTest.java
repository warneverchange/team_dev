package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ArrayUtilsTest {
  @ParameterizedTest
  @MethodSource("provideSortConsumers")
  public void sortTest(Consumer<Integer[]> sortConsumer) {
    Integer[] arr = {-3, 2, 3, 1, 4, 6, 5, -10, 8};
    sortConsumer.accept(arr);
    Integer[] expectedResult = {-10, -3, 1, 2, 3, 4, 5, 6, 8};
    Assertions.assertArrayEquals(arr, expectedResult);
  }

  public static Stream<Arguments> provideSortConsumers() {
    Consumer<Integer[]> first = ArrayUtils::bubbleSort;
    Consumer<Integer[]> second = ArrayUtils::quickSort;
    Consumer<Integer[]> third = ArrayUtils::selectionSort;
    return Stream.of(
        Arguments.of(first), Arguments.of(second), Arguments.of(third)
    );
  }

  @Test
  public static void bubbleSortTestExecutionTime() {
    Stopwat
  }
}
