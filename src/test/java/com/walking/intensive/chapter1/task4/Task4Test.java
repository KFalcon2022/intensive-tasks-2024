package com.walking.intensive.chapter1.task4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.walking.intensive.chapter1.task4.Task4.solveEquation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class Task4Test {

    @ParameterizedTest
    @MethodSource("dataSource")
    void solveEquationTest(String expected, double a, double b, double c) {
        assertEquals(expected, solveEquation(a, b, c));
    }

    static Stream<Arguments> dataSource() {
        return Stream.of(
                of("Количество решений: 0.", 0, 0, -10),
                of("Количество решений: 0.", 0, 0, 1),
                of("Количество решений: 0.", 0, 0, 4),
                of("Бесконечное множество решений.", 0, 0, 0),
                of("Количество решений: 0.", 1, 0, 1),
                of("Количество решений: 0.", 2, 0, 2),
                of("Количество решений: 0.", 3, 0, 3),
                of("Количество решений: 0.", 4, 2, 5),
                of("Количество решений: 0.", 5, 1, 6),
                of("Количество решений: 0.", 6, -1, 8),
                of("Количество решений: 0.", 7, 3, 10),
                of("Количество решений: 0.", 8, 4, 20),
                of("Количество решений: 0.", 9, 5, 30),
                of("Количество решений: 0.", 10, 6, 40),
                of("Количество решений: 1. Корень: 1.0", 0, -2, 2),
                of("Количество решений: 1. Корень: 2.0", 0, -2, 4),
                of("Количество решений: 1. Корень: 4.0", 0, -2, 8),
                of("Количество решений: 1. Корень: 2.0", 0, 20, -40),
                of("Количество решений: 1. Корень: 8.0", 0, 10, -80),
                of("Количество решений: 1. Корень: 0.0", 1, 0, 0),
                of("Количество решений: 1. Корень: 1.0", 1, -2, 1),
                of("Количество решений: 1. Корень: 2.0", 1, -4, 4),
                of("Количество решений: 1. Корень: 3.0", 1, -6, 9),
                of("Количество решений: 1. Корень: 4.0", 1, -8, 16),
                of("Количество решений: 1. Корень: 5.0", 1, -10, 25),
                of("Количество решений: 2. Корни: -5.0;-4.0", 1, 9, 20),
                of("Количество решений: 2. Корни: -3.0;-2.0", 1, 5, 6),
                of("Количество решений: 2. Корни: 3.0;5.0", 1, -8, 15),
                of("Количество решений: 2. Корни: -9.0;5.0", 1, 4, -45),
                of("Количество решений: 2. Корни: -1.0;4.0", -1, 3, 4)
        );
    }
}
