package com.walking.intensive.chapter5.task20;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task20Test {

    @ParameterizedTest
    @MethodSource("getDeterminantSource")
    public void getDeterminantTest(int[][] matrix, int expected) {
        int result = Task20.getDeterminant(matrix);
        assertEquals(expected, result);
    }

    static Stream<Arguments> getDeterminantSource() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {3, 2, 4, 8, 7},
                        {1, 4, 3, 7, 9},
                        {6, 2, 1, 5, 5},
                        {0, 4, 2, 1, 3},
                        {6, 4, 2, 8, 9}
                }, 120),
                Arguments.of(new int[][]{
                        {3, 2, 4},
                        {2, 2, 1},
                        {0, 2, 3}
                }, 16),
                Arguments.of(new int[][]{
                        {3, 2},
                        {2, 2, 1},
                        {0, 2, 3}
                }, null),
                Arguments.of(new int[][]{
                        {3, 2, 4},
                        {2, 2},
                        {0, 2, 3}
                }, null),
                Arguments.of(new int[][]{
                        {3, 2, 4},
                        {2, 2, 1},
                        {0, 2}
                }, null),
                Arguments.of(new int[][]{
                        {3, 2, 4, 5},
                        {2, 2, 1, 6},
                        {0, 2, 3, 4}
                }, null),
                Arguments.of(new int[][]{
                        {3, 2, 4},
                        {2, 2, 1},
                        {0, 2, 3},
                        {0, 2, 3}
                }, null)
        );
    }
}
