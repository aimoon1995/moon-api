package com.moon.moon_thread.moonThread.threadSync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName UnSafetyTickets
 * @Description: 不安全的买票
 * @Author zyl
 * @Date 2020/12/23
 * @Version V1.0
 **/
@Slf4j
public class UnSafetyTickets {


    public static void main(String[] args) {

        Runnable runnable3 = new Asasd();
        new Thread(runnable3, "苦逼的我").start();
        new Thread(runnable3, "牛逼的你").start();
        new Thread(runnable3, "混逼的黄牛党").start();
    }

}


@Slf4j
class Asasd implements Runnable {
    private boolean flag = true;
    private int ticNum = 10;
    static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag) {
            lock.lock();
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    ;

    private void buy() throws InterruptedException {
        if (ticNum <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);
        log.info("{}拿到了第{}张票", Thread.currentThread().getName(), ticNum);
        ticNum--;
    }
}