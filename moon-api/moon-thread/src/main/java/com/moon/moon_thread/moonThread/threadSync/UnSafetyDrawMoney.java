package com.moon.moon_thread.moonThread.threadSync;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UnSafetyDrawMoney
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/23
 * @Version V1.0
 **/
public class UnSafetyDrawMoney {

    public static void main(String[] args) {
        Account account = new Account(10000);
        DrawMoney me = new DrawMoney(account, 1000);
        DrawMoney me1 = new DrawMoney(account, 1000);
        for (int i = 1; i < 6; i++) {
            new Thread(me, "me" + i).start();
            new Thread(me1, "me--1----" + i).start();
        }
    }

};

@Slf4j
class DrawMoney implements Runnable {
    private Account account;
    private int drawMoney;

    public DrawMoney(Account account, int drawMoney) {
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (account) {
            if (account.getMoney() - drawMoney <= 0) {
                log.info("钱不够，{}取不了钱-----------------------------------", Thread.currentThread().getName());
                return;
            }
            Thread.sleep(100);
            account.setMoney(account.getMoney() - drawMoney);
            log.info("{}取{}钱，卡内余额还剩{}", Thread.currentThread().getName(), drawMoney, account.getMoney());
        }
    }
};

@Data
class Account {
    private Integer money;

    public Account(Integer money) {
        this.money = money;
    }


}