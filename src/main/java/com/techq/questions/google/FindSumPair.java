package com.techq.questions.google;

/**
 * @author Asif Akhtar
 * 09/05/2020 20:06
 */
public class FindSumPair {

    public boolean findPairOfSum(int[] values, int sum) {
        for (int value : values) {
            for (int y = 1; y < values.length; y++) {
                if (sum == (value + values[y])) {
                    return true;
                }
            }
        }
        return false;
    }
}
