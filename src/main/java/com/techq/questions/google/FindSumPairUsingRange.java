package com.techq.questions.google;

/**
 * For better performance than O(n2), we this time use ranges. We pick start of array
 * and the end of array and move inwards till we find a match
 *
 * @author Asif Akhtar
 * 09/05/2020 20:26
 */
public class FindSumPairUsingRange {
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
