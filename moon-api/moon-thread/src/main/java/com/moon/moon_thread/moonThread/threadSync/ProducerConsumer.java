package com.moon.moon_thread.moonThread.threadSync;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ProducerConsumer
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/24
 * @Version V1.0
 **/
public class ProducerConsumer {
    public static void main(String[] args) {
        Container container = new Container();
        new Thread(new Produer(container)).start();
        new Thread(new Consumer(container)).start();
    }


}

@Slf4j
class Produer extends Thread {
    private Container container;

    public Produer(Container container) {
        this.container = container;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            container.push();
            Thread.sleep(1000);
        }
    }
}

@Slf4j
class Consumer extends Thread {
    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            container.pop();
            Thread.sleep(1500);
        }
    }
}

/**
 * 产品
 */
@Data
class Ck {
    public Ck(String uuid) {
        this.uuid = uuid;
    }

    private String uuid;
}

@Slf4j
class Container {
    // 容器能装10件物品
    int count = 0;

    // 生产者向容器里放产品
    synchronized void push() throws InterruptedException {
        if (count >= 10) {
            this.wait();
        }
        log.info("----------------------生产者来的时候还剩---->{}", count);
        count++;
        this.notifyAll();
    }

    //消费者消费
    synchronized void pop() throws InterruptedException {
        if (0 >= count) {
            this.wait();
        }
        log.info("----------------------消者来的时候还剩---->{}", count);
        count--;
        this.notifyAll();
    }
}