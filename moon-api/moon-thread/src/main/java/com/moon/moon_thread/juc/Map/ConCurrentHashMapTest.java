package com.moon.moon_thread.juc.Map;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ConCurrentHashMapTest
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
@Slf4j
public class ConCurrentHashMapTest {


    public static void main(String[] args) {
        Map map = new ConcurrentHashMap();
        for (int i = 0; i < 3000; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,5),UUID.randomUUID().toString().substring(0,5));
                log.info("{}",map);
            }).start();
        }
    }
}
