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
            for (int k=0;k<10;k++) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("threadState---->{}",Thread.currentThread().getState());
            }

        };
        Thread thread =  new Thread(re);
        log.info("threadState---->{}",thread.getState());
        thread.start();
        log.info("threadState---->{}",thread.getState());
        for (int i=0; i<10;i++) {
            log.info("mainThread --->{}",i);
            if (i == 5) {
                thread.join();
                log.info("threadState---->{}",thread.getState());
            }
        }


    }

}
