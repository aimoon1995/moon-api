package com.moon.moon_thread.moonThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Yiled
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/21
 * @Version V1.0
 **/
@Slf4j
public class Yiled {

    public static void main(String[] args) {
        Runnable re = () -> {
            log.info("threadName-->{}开始",Thread.currentThread().getName());
            Thread.yield();
            log.info("threadName-->{}结束",Thread.currentThread().getName());
        };
        new Thread(re).start();
        new Thread(re).start();
    }
}
