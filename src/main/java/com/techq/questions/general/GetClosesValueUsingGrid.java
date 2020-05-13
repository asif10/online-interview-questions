package com.techq.questions.general;

import java.util.Arrays;

/**
 * @author Asif Akhtar
 * 12/05/2020 23:33
 */
public class GetClosesValueUsingGrid {
    public int[] closestSumPair(int[] start, int[] end, int target) {
        Arrays.sort(start);
        Arrays.sort(end);

        int row = 0;
        int column = start.length - 1;
        int[] pairs = {start[0], end[0]};
        int diff = Math.abs(start[0] + end[0] - target);

        while (row < start.length && column >= 0) {
            int currentValue = start[row] + end[column] - target;

            if (Math.abs(currentValue) < diff) {
                diff = Math.abs(currentValue);
                pairs[0] = start[row];
                pairs[1] = end[column];
            }

            if (diff == 0) {
                return new int[]{start[row], end[column]};
            } else if (currentValue < 0) {
                row++;
            } else {
                column--;
            }
        }
        return pairs;
    }
}
