package com.walking.intensive.chapter3.task14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.walking.intensive.chapter3.task14.Task14.getObjectCounts;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Task14}.
 */
public class Task14Test {

    @ParameterizedTest
    @MethodSource("testDataSource")
    void testGetObjectCounts(int[][] points, int[][] queries, int[] expectedCountOfPoints) {
        // when
        var result = getObjectCounts(points, queries);

        assertArrayEquals(expectedCountOfPoints, result);
    }

    static Stream<Arguments> testDataSource() {
        // case 1
        int[][] pointsOne = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queriesOne = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] answerOne = {3, 2, 2};

        // case 2
        int[][] pointsTwo = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queriesTwo = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        int[] answerTwo = {2, 3, 2, 4};

        // case 3 negative radars radius
        int[][] pointsThree = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queriesThree = {{1, 2, 3}, {2, 2, -5}, {4, 3, -1}, {4, 3, -6}};
        int[] answerThree = {};

        // case 4 radars without radius
        int[][] pointsFour = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queriesFour = {{1, 2, 1}, {2, 2}, {4, 3}, {4, 3}};
        int[] answerFour = {};

        // case 5 points with incorrect coordinates
        int[][] pointsFive = {{1, 1}, {2}, {}, {4, 4, 3, 13, 8, 6}, {-10}};
        int[][] queriesFive = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        int[] answerFive = {};

        // case 6 radars with additional parameters
        int[][] pointsSix = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queriesSix = {{1, 2, 2}, {2, 2, 2, 12, 8}, {4, 3, 2, 16, 5, 8}, {4, 3, 3, 11}};
        int[] answerSix = {};

        return Stream.of(
                Arguments.of(pointsOne, queriesOne, answerOne),
                Arguments.of(pointsTwo, queriesTwo, answerTwo),
                Arguments.of(pointsThree, queriesThree, answerThree),
                Arguments.of(pointsFour, queriesFour, answerFour),
                Arguments.of(pointsFive, queriesFive, answerFive),
                Arguments.of(pointsSix, queriesSix, answerSix)
        );
    }
}
