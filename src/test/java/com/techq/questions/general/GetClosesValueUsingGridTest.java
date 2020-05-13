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
 * 12/05/2020 23:34
 */
class GetClosesValueUsingGridTest {
    static Stream<Arguments> shouldFindPositionInArray() {
        return Stream.of(
                containsNearestTo24Above(),
                containsNearestTo24Below(),
                containsAValueOf24(),
                nearestAmount001(),
                nearestAmount003(),
                nearestAmount004(),
                nearestAmount002()
        );
    }

    private static Arguments nearestAmount004() {
        int[] c1 = {-1, 3, 8, 2, 9, 5};
        int[] c2 = {-1, 3, 8, 2, 9, 20};
        int cTarget = 24;
        return Arguments.of("nearestAmount004", new int[]{3, 20}, c1, c2, cTarget);
    }

    private static Arguments nearestAmount003() {
        int[] c1 = {7, 4, 1, 10};
        int[] c2 = {4, 5, 8, 7};
        int cTarget = 13;
        return Arguments.of("nearestAmount003", new int[]{4,8}, c1, c2, cTarget);
    }

    private static Arguments nearestAmount002() {
        int[] c1 = {6, 8, -1, -8, -3};
        int[] c2 = {4, -6, 2, 9, -3};
        int cTarget = 3;
        return Arguments.of("nearestAmount002", new int[]{-1, 4}, c1, c2, cTarget);
    }


    private static Arguments nearestAmount001() {
        return Arguments.of("nearestAmount001", new int[]{-16, 2},
                new int[]{19, 14, 6, 11, -16, 14, -16, -9, 16, 13},
                new int[]{13, 9, -15, -2, -18, 16, 17, 2, -11, -7},
                -15);
    }

    private static Arguments containsNearestTo24Above() {
        return Arguments.of("contains above nearest 24 in both arrays", new int[]{8, 20}, new int[]{-1, 3, 8, 2, 9, 8}, new int[]{4, 1, 2, 10, 5, 20}, 27);
    }

    private static Arguments containsNearestTo24Below() {
        return Arguments.of("contains below nearest 24 in both arrays", new int[]{3, 20}, new int[]{-1, 3, 8, 2, 9, 8}, new int[]{4, 1, 2, 10, 5, 20}, 24);
    }

    private static Arguments containsAValueOf24() {
        return Arguments.of("contains 24 in both arrays", new int[]{4, 20}, new int[]{-1, 3, 8, 4, 2, 9, 5}, new int[]{4, 1, 2, 10, 5, 11, 20}, 24);
    }

    @DisplayName("should find pair of values matching target or nearest...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldFindPositionInArray(String description, int[] expectedResponse, int[] start, int[] end, int target) {
        int[] matching = new GetClosesValueUsingGrid().closestSumPair(start, end, target);
        System.out.println(Arrays.toString(matching));
        assertArrayEquals(expectedResponse, matching);
    }
}