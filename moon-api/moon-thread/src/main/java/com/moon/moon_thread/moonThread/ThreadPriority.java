package com.moon.moon_thread.moonThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ThreadPriority
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/22
 * @Version V1.0
 **/
@Slf4j
public class ThreadPriority {


    public static void main(String[] args) {
        Runnable re = () -> {

        };
        Thread t1 = new Thread(re);
        Thread t2 = new Thread(re);
        Thread t3 = new Thread(re);
        Thread t4 = new Thread(re);
        Thread t5 = new Thread(re);
        log.info(String.valueOf(t1.getPriority()));
        log.info(String.valueOf(t2.getPriority()));
        log.info(String.valueOf(t3.getPriority()));
        log.info(String.valueOf(t4.getPriority()));
        log.info(String.valueOf(t5.getPriority()));
    }
}
