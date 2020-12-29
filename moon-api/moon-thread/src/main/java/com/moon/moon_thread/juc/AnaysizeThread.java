package com.moon.moon_thread.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName AnaysizeThread
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
public class AnaysizeThread {
    public static void main(String[] args) throws InterruptedException {
        MoonZ moon = new MoonZ();
        MoonZ moon1 = new MoonZ();
        new Thread(()->{
            try {
                moon.push();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                moon1.push();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
};

@Slf4j
class MoonZ {

    int num = 1;

    public static synchronized void push() throws InterruptedException {
        Thread.sleep(3000);
        log.info("psuh ------------------");
    }

    public   synchronized void pop() throws InterruptedException {
     log.info("pop ------------------");
    }


};
