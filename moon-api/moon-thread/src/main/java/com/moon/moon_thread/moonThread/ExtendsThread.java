package com.moon.moon_thread.moonThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ExtendsThread
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/21
 * @Version V1.0
 **/
@Slf4j
public class ExtendsThread extends Thread {
    /**
     * Thread 类实现的是runable接口
     */
    @Override
    public void run() {
        for (int i = 0; i< 10;i++) {
            log.info("继承Thread类的线程————>{}",i);
        }
    }

    public static  void  main (String[] args) {
        Thread t = new ExtendsThread();
        t.start();
        for (int i = 0; i< 10;i++) {
            log.info("main线程————>{}",i);
        }
    }
}
