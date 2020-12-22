package com.moon.moon_proxy.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName StaticProxy
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/21
 * @Version V1.0
 **/
@Slf4j
public class StaticProxy {
    public static void main(String[] args) {
        Marry me = new Me();
        Marry marryCompany = new MarryCompany(me);
        marryCompany.happy();
    }

};
interface Marry {
    public void happy();
};
@Slf4j
class Me implements Marry {
    @Override
    public void happy() {
        log.info("me marry");
    }
};
@Slf4j
class MarryCompany implements Marry {
    private Marry tar;
    public MarryCompany(Marry target) {
        this.tar = target;
    }
    @Override
    public void happy() {
        log.info("ready to marry");
        tar.happy();
        log.info("had marry");
    }
};