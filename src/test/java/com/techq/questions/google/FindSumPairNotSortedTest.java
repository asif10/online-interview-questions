package com.techq.questions.google;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Asif Akhtar
 * 11/05/2020 19:56
 */
class FindSumPairNotSortedTest {
    static Stream<Arguments> shouldFindPositionInArray() {
        return Stream.of(
                containsMultipleOf4s(),
                containsASumOf5()

        );
    }

    private static Arguments containsMultipleOf4s() {
        return Arguments.of("contains 4,4", true, new int[]{4, 1, 2, 4}, 8);
    }

    private static Arguments containsASumOf5() {
        return Arguments.of("contains 3,2", true, new int[]{1, 4, 3, 2}, 5);
    }

    private static Arguments itemIsInTheLast() {
        int max = 1000;
        return Arguments.of("item is in the last position", max, IntStream.rangeClosed(0, max).toArray(), max);
    }

    @DisplayName("should find pair of values matching sum not sorted...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldFindPositionInArray(String description, boolean expectedResponse, int[] values, int sum) {
        boolean position = new FindSumPairNotSorted().findPairOfSum(values, sum);
        assertEquals(expectedResponse, position);
    }
}