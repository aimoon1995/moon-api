package com.moon.moon_thread.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionTest
 * @Description:   一个对象里面，没有和锁挂钩的方法正常执行
 * 在下面例子中，线程B执行printB方法是不需要等待线程A执行完毕释放锁的
 * 用ReentrantLock 加锁情况是一样的
 * @Author zyl
 * @Date 2020/12/25
 * @Version V1.0
 **/
public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {
        Moon moon = new Moon();
        new Thread(()-> {
            moon.printA();
        },"A").start();
        Thread.sleep(1000);
        new Thread(()-> {
            moon.printB();
        },"B").start();
    }

}

/**
 * * @Description:   一个对象里面，没有和锁挂钩的方法正常执行
 *  * 在下面例子中，线程B执行printB方法是不需要等待线程A执行完毕释放锁的
 *  * 用ReentrantLock 加锁情况是一样的
 */
@Slf4j
class  Moon {
    Lock lock = new ReentrantLock();
    int num  = 2;
    public synchronized void printA (){
        try {
              Thread.sleep(10000);
              log.info("{}加锁",Thread.currentThread().getName());
          num = 2;
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
        }
    }
    public  void printB (){
        try {
            log.info("{}打印",Thread.currentThread().getName());
            num ++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }


}


