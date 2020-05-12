package com.techq.questions.google;

/**
 * @author Asif Akhtar
 * 11/05/2020 20:09
 */
public class FindSumPairUsingNonRecursion {
    public boolean findPairOfSum(int[] values, int sum) {

        int start = 0;
        int end = values.length - 1;

        while (start < end) {
            if (checkRange(values, start) || checkRange(values, end)) {
                return false;
            }
            int result = values[start] + values[end];

            if (result > sum) {
                end -= 1;
            } else if (result < sum) {
                start += 1;
            } else {
                return true;
            }
        }
        return false;
    }


    private boolean checkRange(int[] values, int start) {
        return start < 0 || start >= values.length;
    }
}
