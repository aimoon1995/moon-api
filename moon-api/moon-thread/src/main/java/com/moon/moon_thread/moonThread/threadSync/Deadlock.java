package com.moon.moon_thread.moonThread.threadSync;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Deadlock
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/24
 * @Version V1.0
 **/
public class Deadlock {

    public static void main(String[] args) {
        Tipstick tipstick = new Tipstick();
        Mirror mirror = new Mirror();
        Runnable runnable1 = new Re(tipstick, mirror, true);
        Runnable runnable2 = new Re(tipstick, mirror, false);
        new Thread(runnable1, "one").start();
        new Thread(runnable2, "two").start();

    }
}

class Tipstick {
};

class Mirror {
};

@Slf4j
class Re implements Runnable {
    private Tipstick tipstick;
    private Mirror mirror;
    private boolean flag;

    public Re(Tipstick tipstick, Mirror mirror, boolean flag) {
        this.tipstick = tipstick;
        this.mirror = mirror;
        this.flag = flag;
    }

    @SneakyThrows
    @Override
    public void run() {
        if (flag) {
            synchronized (tipstick) {
                log.info("{}拿到口红", Thread.currentThread().getName());
                Thread.sleep(1000);
                synchronized (mirror) {
                    log.info("{}拿到镜子", Thread.currentThread().getName());
                }
            }
        } else {
            synchronized (mirror) {
                log.info("{}拿到镜子", Thread.currentThread().getName());
                Thread.sleep(2000);
                synchronized (tipstick) {
                    log.info("{}拿到口红", Thread.currentThread().getName());
                }
            }
        }
    }
}


