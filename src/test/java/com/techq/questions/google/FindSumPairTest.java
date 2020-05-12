package com.techq.questions.google;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * From an array find a pair which matches the sum value
 * https://www.youtube.com/watch?v=XKu_SEDAykw
 * @author Asif Akhtar
 * 09/05/2020 20:07
 */
class FindSumPairTest {
    static Stream<Arguments> shouldFindPositionInArray() {
        return Stream.of(
                containsMultipleOf4s(),
                containsNoValues()
        );
    }

    private static Arguments containsMultipleOf4s() {
        return Arguments.of("contains 4,4", true, new int[]{1, 2, 4, 4}, 8);
    }

    private static Arguments containsNoValues() {
        return Arguments.of("contains no pair", false, new int[]{1, 2, 3, 9}, 8);
    }

    private static Arguments itemIsInTheLast() {
        int max = 1000;
        return Arguments.of("item is in the last position", max, IntStream.rangeClosed(0, max).toArray(), max);
    }

    @DisplayName("should find pair of values matching sum...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldFindPositionInArray(String description, boolean expectedResponse, int[] values, int sum) {
        boolean position = new FindSumPair().findPairOfSum(values, sum);
        assertEquals(expectedResponse, position);
    }
}