package com.ouyang.java_8_new_feature;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.ouyang.think_in_java4.Test.isOk;

public class Lambda {

    @Test
    public void testArrays() {
        String[] args = new String[100];
        Stream.of(args).forEach(System.out::println);
        String str = "";
        str += "hello";
        System.out.println(str);
        isOk();
        Random random = new Random();
    }

    @Test
    public void test1() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        System.out.println(longAdder.toString());
        AtomicReference<Integer> atomicReference = new AtomicReference<>();
        atomicReference.getAndUpdate(integer -> integer == null ? 0 : integer);
        Random r = new Random();
        IntStream.range(0, 10).forEach((i) -> System.out.println(r.nextInt(100)));

        Optional<Object> optional = Optional.of(null);
        System.out.println(optional.flatMap(o -> Optional.of(o.toString())).get());
//        union all 和 union
    }

    @Test
    public void testIsPowerOfTwo() {
        IntStream.range(0, 100).filter(this::isPowerOfTwo).forEach(System.out::println);
    }

    /**
     * Given an integer, write a function to determine if it is a power of two.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return Integer.bitCount(n) <= 1;
    }
}
