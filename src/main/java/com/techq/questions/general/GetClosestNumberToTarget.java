package com.techq.questions.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Asif Akhtar
 * 12/05/2020 13:49
 */
public class GetClosestNumberToTarget {
    public int findClosestTarget(int[] start, int target) {
        List<Integer> values = new ArrayList<>();
        for (int value : start) {
            values.add(Math.abs(value - target));
        }

        Collections.sort(values);
        return values.get(0);
    }
}
