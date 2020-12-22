package com.moon.moon_thread.moonThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ThreadJoin
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/22
 * @Version V1.0
 **/
@Slf4j
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Runnable re = () ->{
            for (int k=0;k<1000;k++) {
                log.info("moonThread join -->{}",k);
            }

        };
        Thread thread =  new Thread(re);
        thread.start();
        for (int i=0; i<100;i++) {
            log.info("mainThread --->{}",i);
            if (i == 20) {
                thread.join();
            }
        }
    }

}
