package com.moon.moon_proxy.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName LambdaExpression
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/21
 * @Version V1.0
 **/
@Slf4j
public class LambdaExpression {
    /**
     * 静态内部类
     *
     * @param
     */
    static class LambdaStatic implements ILamda {
        @Override
        public void lambda() {
            log.info("---------->静态内部类");
        }
    }

    public static void main(String[] args) {
        ILamda lambda = new LambdaImpl();
        lambda.lambda();
        lambda = new LambdaStatic();
        lambda.lambda();
        lambda = new ILamda() {
            @Override
            public void lambda() {
                log.info("---------->匿名内部类");
            }
        };
        lambda.lambda();
        lambda = () -> {
            log.info("---------->lambda表达式");
        };
        lambda.lambda();
        IeLamda ieLamda = (String a,String b)->{
            log.info("---------->lambda表达式{}",a);
        };
        ieLamda.lambda("moon","");
        ieLamda = (a,b)->{
            log.info("---------->lambda表达式{}",a);
        };
        ieLamda.lambda("moon","");
    }
}

interface ILamda {
    void lambda();
}

interface IeLamda {
    void lambda(String a,String b);
}

@Slf4j
class LambdaImpl implements ILamda {
    @Override
    public void lambda() {
        log.info("---------->实现接口");
    }
}