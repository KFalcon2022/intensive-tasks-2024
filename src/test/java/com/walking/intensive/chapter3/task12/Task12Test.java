package com.walking.intensive.chapter3.task12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.walking.intensive.chapter3.task12.Task12.getMovementsNumber;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task12Test {

    @ParameterizedTest
    @MethodSource("testDataSource")
    void testGetMovementsNumber(String baskets, int[] expectedArray) {
        // when
        var result = getMovementsNumber(baskets);

        assertArrayEquals(expectedArray, result);
    }

    static Stream<Arguments> testDataSource() {
        return Stream.of(
                Arguments.of("001011", new int[]{11, 8, 5, 4, 3, 4}),
                Arguments.of("110", new int[]{1, 1, 3}),
                Arguments.of("235", new int[]{}),
                Arguments.of("fgh432", new int[]{}),
                Arguments.of("-110", new int[]{}),
                Arguments.of("%&)(5_=:Привет", new int[]{}),
                Arguments.of("11010T", new int[]{}));
    }
}
