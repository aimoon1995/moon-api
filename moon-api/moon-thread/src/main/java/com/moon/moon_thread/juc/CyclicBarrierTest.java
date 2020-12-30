package com.moon.moon_thread.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierTest
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
@Slf4j
public class CyclicBarrierTest {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            log.info("集齐7个葫芦娃，组团干蛇精副本");
        });

        for (int i = 1; i <= 7; i++) {
            int temp = i;
            new Thread(()->{
                log.info("{}娃来报道",temp);
                try {
                    cyclicBarrier.await(); //
                    log.info("{}娃报道完毕",temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
