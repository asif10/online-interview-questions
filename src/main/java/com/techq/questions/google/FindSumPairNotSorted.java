package com.techq.questions.google;

/**
 * Find a sum but the list is unordered
 *
 * @author Asif Akhtar
 * 11/05/2020 19:55
 */
public class FindSumPairNotSorted {
    public boolean findPairOfSum(int[] values, int sum) {
        return findPairOfSum(values, sum, 0, values.length - 1);
    }

    public boolean findPairOfSum(int[] values, int sum, int start, int end) {
        if (checkRange(values, start) || checkRange(values, end)) {
            return false;
        }
        int result = values[start] + values[end];

        if (result > sum) {
            return findPairOfSum(values, sum, start, end - 1);
        } else if (result < sum) {
            return findPairOfSum(values, sum, start + 1, end);
        } else {
            return true;
        }
    }

    private boolean checkRange(int[] values, int start) {
        return start < 0 || start >= values.length;
    }
}
