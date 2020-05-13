package com.techq.questions.general;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Asif Akhtar
 * 12/05/2020 22:58
 */
class CSPTest {
    static Stream<Arguments> shouldFindPositionInArray() {
        return Stream.of(
                containsNearestTo24Above(),
                containsNearestTo24Below(),
                containsAValueOf24()
        );
    }

    private static Arguments containsNearestTo24Above() {
        return Arguments.of("contains above nearest 24 in both arrays", new int[]{8, 20}, new int[]{-1, 3, 8, 2, 9, 8}, new int[]{4, 1, 2, 10, 5, 20}, 27);
    }

    private static Arguments containsNearestTo24Below() {
        return Arguments.of("contains below nearest 24 in both arrays", new int[]{3, 20}, new int[]{-1, 3, 8, 2, 9, 8}, new int[]{4, 1, 2, 10, 5, 20}, 24);
    }

    private static Arguments containsAValueOf24() {
        return Arguments.of("contains 24 in both arrays", new int[]{4, 20}, new int[]{-1, 3, 8, 4, 2, 9, 5}, new int[]{4, 1, 2, 10, 5, 20}, 24);
    }

    @DisplayName("should find pair of values matching target or nearest...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldFindPositionInArray(String description, int[] expectedResponse, int[] start, int[] end, int target) {
        int[] matching = new CSP().closestSumPair(start, end, target);
        System.out.println(Arrays.toString(matching));
        assertArrayEquals(expectedResponse, matching);
    }
}