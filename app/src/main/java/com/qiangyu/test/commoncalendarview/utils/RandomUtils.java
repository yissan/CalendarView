package com.qiangyu.test.commoncalendarview.utils;

import java.util.Random;

/**
 * yangqiangyu on 14/11/2016 13:10
 */
public class RandomUtils {

    public static final Random JVM_RANDOM = new JVMRandom();


    /**
     * <p>Returns a pseudorandom, uniformly distributed int value
     * between <code>0</code> (inclusive) and the specified value
     * (exclusive), from the Math.random() sequence.</p>
     *
     * @param n  the specified exclusive max-value
     * @return the random int
     */
    public static int nextInt(int n) {
        return nextInt(JVM_RANDOM, n);
    }


    /**
     * <p>Returns a pseudorandom, uniformly distributed int value
     * between <code>0</code> (inclusive) and the specified value
     * (exclusive), from the given Random sequence.</p>
     *
     * @param random the Random sequence generator.
     * @param n  the specified exclusive max-value
     * @return the random int
     */
    public static int nextInt(Random random, int n) {
        // check this cannot return 'n'
        return random.nextInt(n);
    }

}
