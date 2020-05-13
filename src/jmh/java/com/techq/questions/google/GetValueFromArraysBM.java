package com.techq.questions.google;

import com.techq.questions.general.CSP;
import com.techq.questions.general.GetClosesValueUsingGrid;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Asif Akhtar
 * 12/05/2020 14:32
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 1)        // Warmup Iteration = 3
@Measurement(iterations = 1)    // Iteration = 8
public class GetValueFromArraysBM {
    public static int[] LIST1;
    public static int[] LIST2;

    @Param({"1", "100", "1000"})
    int size;
    int[] xs;

    @Setup
    public void setup() {
        xs = new int[size];
        for (int c = 0; c < size; c++) {
            xs[c] = c;
        }

        LIST1 = getRandomNumberUsingInts(0, size);
        LIST2 = getRandomNumberUsingInts(0, size);
    }

    public int[] getRandomNumberUsingInts(int min, int max) {
        return IntStream.range(min, max).toArray();
    }

//    @Benchmark
//    public void GetValueFromArrays(Blackhole bh) {
//        for (int x : xs) {
//            bh.consume(new GetValueFromArrays().findTarget(LIST1, LIST2, x));
//        }
//    }

//    @Benchmark
//    public void GetValueFromArraysNoList(Blackhole bh) {
//        for (int x : xs) {
//            bh.consume(new GetValueFromArrays().findTargetV3(LIST1, LIST2, x));
//        }
//    }

    @Benchmark
    public void GetValueFromArraysNoList(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new CSP().closestSumPair(LIST1, LIST2, x));
        }
    }

    @Benchmark
    public void GetClosesValueUsingGrid(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new GetClosesValueUsingGrid().closestSumPair(LIST1, LIST2, x));
        }
    }
}
