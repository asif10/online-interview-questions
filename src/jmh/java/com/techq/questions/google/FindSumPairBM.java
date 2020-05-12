package com.techq.questions.google;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * @author Asif Akhtar
 * 09/05/2020 22:44
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 1)        // Warmup Iteration = 3
@Measurement(iterations = 1)    // Iteration = 8
public class FindSumPairBM {
    public static final int[] ORDERED = {1, 2, 4, 4, 5, 6, 8, 10, 12, 15};
    public static final int[] UNORDERED = {15, 4, 2, 12, 1, 4, 10, 8, 5, 6};

    @Param({"1000", "10000"})
    int size;

    int[] xs;

    @Setup
    public void setup() {
        xs = new int[size];
        for (int c = 0; c < size; c++) {
            xs[c] = c;
        }
    }

    @Benchmark
    public void FindSumPair(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new FindSumPair().findPairOfSum(ORDERED, x));
        }
    }

    @Benchmark
    public void FindSumPairUsingRangeORDERED(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new FindSumPairUsingRange().findPairOfSum(ORDERED, x));
        }
    }

    @Benchmark
    public void FindSumPairUsingNonRecursionORDERED(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new FindSumPairUsingNonRecursion().findPairOfSum(ORDERED, x));
        }
    }

    @Benchmark
    public void FindSumPairUsingStorageORDERED(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new FindSumPairUsingStorage().findPairOfSum(ORDERED, x));
        }
    }

    @Benchmark
    public void FindSumPairUsingRangeUNORDERED(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new FindSumPairUsingRange().findPairOfSum(UNORDERED, x));
        }
    }

    @Benchmark
    public void FindSumPairUsingNonRecursionUNORDERED(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new FindSumPairUsingNonRecursion().findPairOfSum(UNORDERED, x));
        }
    }

    @Benchmark
    public void FindSumPairUsingStorageUNORDERED(Blackhole bh) {
        for (int x : xs) {
            bh.consume(new FindSumPairUsingStorage().findPairOfSum(UNORDERED, x));
        }
    }
}
