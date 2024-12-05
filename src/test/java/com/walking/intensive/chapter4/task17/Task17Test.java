package com.walking.intensive.chapter4.task17;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task17Test {

    @ParameterizedTest
    @MethodSource("sortTestSource")
    public void sortByBubbleTest(int[] array, int[] expected) {
        int[] result = Task17.sortByBubble(array);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("sortTestSource")
    public void sortByQuicksortTest(int[] array, int[] expected) {
        int[] result = Task17.sortByQuicksort(array);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> sortTestSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 0, -1, -10, -20}, new int[]{-20, -10, -1, 0, 1, 2, 4}),
                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(null, new int[]{})
        );
    }
}
