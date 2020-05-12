package com.techq.questions.general;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given 2 arrays find an element from each which makes up the closest to the target
 * e.g.
 * [-1,3,8,2,9,5]
 * [4,1,2,10,5,20]
 * Target = 24
 * <p>
 * answer is (5,20) and (2,20)
 *
 * @author Asif Akhtar
 * 12/05/2020 02:16
 */
public class GetValueFromArrays {
    public Integer[] findTarget(int[] start, int[] end, int target) {
        Map<Integer, List<Integer[]>> values = new TreeMap<>();
        for (int started : start) {
            for (int ended : end) {
                int sum = Math.abs((started + ended) - target);
                if (values.containsKey(sum)) {
                    values.get(sum).add(new Integer[]{started, ended});
                } else {
                    List<Integer[]> list = new ArrayList<>();
                    list.add(new Integer[]{started, ended});
                    values.put(sum, list);
                }
            }
        }

        List<Integer[]> results = values.values().stream().limit(1).flatMap(Collection::stream).collect(Collectors.toList());
        return results.get(0);
    }

    public Integer[] findTargetV2(int[] start, int[] end, int target) {
        Map<Integer, Integer[]> values = new TreeMap<>();
        for (int started : start) {
            for (int ended : end) {
                int sum = Math.abs((started + ended) - target);
                values.put(sum, new Integer[]{started, ended});
            }
        }

        List<Integer[]> results = values.values().stream().limit(1).collect(Collectors.toList());
        return results.get(0);
    }

    public Integer[] findTargetV3(int[] start, int[] end, int target) {
        Set<Integer> set = Arrays.stream(start).boxed().collect(Collectors.toSet());

        for (int ended : end) {
            int expect = target - ended;
            if (set.contains(expect)) {
                return new Integer[]{expect, ended};
            }
        }

        int topIndex = target + 100;
        int index = target + 1;
        int topDiff = 0;
        Integer[] matchesTop = new Integer[2];

        OUTER:
        while (index < topIndex) {
            for (int ended : end) {
                topDiff = index - ended;
                if (set.contains(topDiff)) {
                    matchesTop[0] = topDiff;
                    matchesTop[1] = ended;
                    break OUTER;
                }
            }
            index++;
        }

        int bottomIndex = target - 100;
        index = target - 1;
        Integer[] matchesLow = new Integer[2];

        OUTER:
        while (index > bottomIndex) {
            for (int ended : end) {
                int expect = index - ended;
                if (set.contains(expect)) {
                    matchesLow[0] = expect;
                    matchesLow[1] = ended;
                    break OUTER;
                }
            }
            index--;
        }

        int top = target - Math.abs(matchesTop[1] + matchesTop[0]);
        int bottom = target - Math.abs(matchesLow[1] + matchesLow[0]);

        if (Math.abs(top) > Math.abs(bottom)) {
            return matchesLow;
        } else {
            return matchesTop;
        }
    }
}
