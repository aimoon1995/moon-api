package com.moon.moon_thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchTest
 * @Description: 1.CountDownLatch——用于n个线程等待其余M个线程结束。
 *
 * A CountDownLatch用给定的计数初始化。 await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，之后所有等待线程被释放，并且任何后续的await 调用立即返回。 这是一个一次性的现象 - 计数无法重置。 如果您需要重置计数的版本，请考虑使用CyclicBarrier 。
 *
 * A CountDownLatch是一种通用的同步工具，可用于多种用途。 一个CountDownLatch为一个计数的CountDownLatch用作一个简单的开/关锁存器，或者门：所有线程调用await在门口等待，直到被调用countDown()的线程打开。 一个CountDownLatch初始化N可以用来做一个线程等待，直到N个线程完成某项操作，或某些动作已经完成N次。
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/

class CountDownLatchTest {
    static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
            Thread.sleep(1000);
        }
        System.out.println("===打卡===");
        startSignal.countDown();  // startSignal 计数为0的时候，上面的各个线程才能继续打印  -===开始工作了！！===
        try {
            doneSignal.await(); // doneSignal 计数为0的时候，主线程才能继续向下走
            System.out.println("===all finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Worker implements Runnable {
    final CountDownLatch startSignal;
    final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal,CountDownLatch doneSignal){
        this.startSignal=startSignal;
        this.doneSignal=doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await(); // startSignal计数不为0, 则线程中代码不会继续向下执行
            System.out.println("===开始工作了！！===");
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}