package com.ouyang.contest42;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    /**
     * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
     * <p>
     * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
     * <p>
     * Example 1:
     * Input: nums = [1,2,2,4]
     * Output: [2,3]
     * Note:
     * The given array size will in the range [2, 10000].
     * The given array's numbers won't have any order.
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n + 1)) / 2;
        for (int i : nums) {
            if (set.contains(i))
                duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[]{duplicate, (int) sum + duplicate};
    }

    public int[] findErrorNums2(int[] nums) {
        Map.Entry<MyInteger, Long> value = Arrays.stream(nums)
                .mapToObj(MyInteger::new)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 1)
                .findFirst()
                .get();
        long count = Arrays.stream(nums).count();
        int n = nums.length;
        long sum = (n * (n + 1)) / 2;
        return new int[]{value.getKey().num, (int) (value.getKey().num + sum - count)};
    }

    public class MyInteger {
        int num;
        MyInteger(int num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MyInteger)) {
                return false;
            }
            return num == ((MyInteger) obj).num;
        }
    }
}
