package com.moon.moon_thread.juc.Set;

import cn.hutool.core.collection.ConcurrentHashSet;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName CopyOnWriteArraySetThread
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
@Slf4j
public class CopyOnWriteArraySetThread {

    public static void main(String[] args) {
        Set<String> list = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 1000; i++) {
            new Thread(()->{
                list.add("UUID.randomUUID().toString().substring(0,5)");
                log.info("{}",list);
            },i+"").start();
        }
    }
}
