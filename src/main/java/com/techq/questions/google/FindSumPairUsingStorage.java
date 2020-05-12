package com.techq.questions.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses a list to add a value if we don't find the diff from the previous, this way
 * we can keep going forward looking for the value
 *
 * @author Asif Akhtar
 * 11/05/2020 20:26
 */
public class FindSumPairUsingStorage {
    public boolean findPairOfSum(int[] values, int sum) {
        List<Integer> linkedList = new ArrayList<>();

        for (int value : values) {
            if (linkedList.contains(value)) {
                return true;
            } else {
                linkedList.add(sum - value);
            }
        }
        return false;
    }
}
