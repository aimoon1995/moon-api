package com.moon.moon_thread.moonThread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ImplementRunable
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/21
 * @Version V1.0
 **/
@Slf4j
public class ImplementRunable implements Runnable {

    private Integer  ticketsNum = 10;
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (ticketsNum < 1) {
                break;
            }
            log.info("{}拿到第{}张票",Thread.currentThread().getName(),ticketsNum);
            Thread.sleep(1000);
            ticketsNum--;
        }
    }

    public static void main(String[] args) {
        ImplementRunable implementRunable = new ImplementRunable();
        Thread threadMoon = new Thread(implementRunable,"moon");
        Thread  threadSun = new Thread(implementRunable,"sun");
        Thread threadMars = new Thread(implementRunable,"mars");
        threadMoon.start();
        threadMars.start();
        threadSun.start();
    }

}
