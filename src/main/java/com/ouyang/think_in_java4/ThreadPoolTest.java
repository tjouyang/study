package com.ouyang.think_in_java4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    public static AtomicInteger atomicInteger;
    public static Result result;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int trueRes = 0;
        for (int i = 0; i < new Random().nextInt(1000); i++) { // 模拟一些数据过来
            list.add(i);
            trueRes += i;
        }
        System.out.println(list);
        System.out.println("实际结果：" + trueRes);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        atomicInteger = new AtomicInteger(0);
        int size = list.size() / 10; // 每个线程计算的量, 这个10 也可以抽出来自己设置
        int last = 0;
        result = new Result();
        for (int i = 1; i < 10; i ++) {
            List<Integer> data;
            if (i == 9) {
                data = list.subList(last, list.size()); // 最后一个线程多做点事情或者少做点事情...
            } else {
                data = list.subList(last, i * size);
            }
            last = i * size;
            executorService.execute(new MyRunnable(data, result));
        }
    }

    public static class Result {
        int value = 0;

        public synchronized void addResult(int result) {
            this.value += result;
        }
    }

    public static class MyRunnable implements Runnable {

        private final List<Integer> integers;
        private Result result;

        public MyRunnable(List<Integer> integers, Result result){
            this.integers = integers;
            this.result = result;
        }

        @Override
        public void run() {
            int res = 0;
            for (int i : integers) {
                res += i; // 计算逻辑
            }
            System.out.println("线程计算完毕：" + res);
            result.addResult(res);
            atomicInteger.addAndGet(1);
            notifyResult();
        }
    }

    public static void notifyResult() {
        if (atomicInteger.get() < 9) {
            // 还有线程没有计算完毕
            return;
        }
        System.out.println("多线程结果：" + result.value);
        System.exit(0);
    }

}
