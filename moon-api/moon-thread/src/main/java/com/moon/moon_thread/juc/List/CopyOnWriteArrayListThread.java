package com.moon.moon_thread.juc.List;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName CopyOnWriteArrayListThread
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
@Slf4j
public class CopyOnWriteArrayListThread {


    /**
     * CopyOnWriteArrayList  写入时复制策略，使用ReentrantLock锁保证线程安全，效率高于vector
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                log.info("{}",list);
            },i+"").start();
        }
    }
}
