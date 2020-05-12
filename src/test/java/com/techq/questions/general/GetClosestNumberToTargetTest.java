package com.techq.questions.general;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Asif Akhtar
 * 12/05/2020 13:50
 */
class GetClosestNumberToTargetTest {
    static Stream<Arguments> shouldFindPositionInArray() {
        return Stream.of(
                findClosestTo10(),
                findActualValue(),
                findClosestTo15(),
                findClosestToNegative10()
        );
    }

    private static Arguments findClosestTo10() {
        return Arguments.of("closest to 10 is 9", 1, new int[]{1, 2, 3, 4, 5, 9, 18}, 10);
    }

    private static Arguments findClosestTo15() {
        return Arguments.of("closest to 15 is 11", 4, new int[]{1, 2, 3, 4, 5, 9, 11, 45}, 15);
    }

    private static Arguments findClosestToNegative10() {
        return Arguments.of("closest to -10 is -6", 4, new int[]{0,-4,-33,-6,-5, 45}, -10);
    }


    private static Arguments findActualValue() {
        return Arguments.of("closest to 10 is 10", 0, new int[]{1, 2, 10, 3, 4, 5, 9, 18}, 10);
    }

    @DisplayName("should find closest to number...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldFindPositionInArray(String description, int expectedResponse, int[] end, int target) {
        int matching = new GetClosestNumberToTarget().findClosestTarget(end, target);
        assertEquals(expectedResponse, matching);
    }
}