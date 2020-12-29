package com.moon.moon_thread.moonThread.threadSync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UnsafetyList
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/23
 * @Version V1.0
 **/
@Slf4j
public class UnsafetyList {


    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();// 不安全
        // List<String> list = new CopyOnWriteArrayList<>(); // 安全
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }, "NAME-->" + i).start();
        }
        Thread.sleep(10000);
        log.info("{}", list.size());
    }
}

class add implements Runnable {

    private List<String> list;

    public add(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {

        list.add(Thread.currentThread().getName());

    }

}
