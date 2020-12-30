package com.moon.moon_thread.juc.Map;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName HashMapTest
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
@Slf4j
public class HashMapTest {

    /**
     * java.util.ConcurrentModificationException
     * 	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1437)
     * 	at java.util.HashMap$EntryIterator.next(HashMap.java:1471)
     * 	at java.util.HashMap$EntryIterator.next(HashMap.java:1469)
     * 	at java.util.AbstractMap.toString(AbstractMap.java:554)
     * 	at org.slf4j.helpers.MessageFormatter.safeObjectAppend(MessageFormatter.java:277)
     * 	at org.slf4j.helpers.MessageFormatter.deeplyAppendParameter(MessageFormatter.java:249)
     * 	at org.slf4j.helpers.MessageFormatter.arrayFormat(MessageFormatter.java:211)
     * 	at org.slf4j.helpers.MessageFormatter.arrayFormat(MessageFormatter.java:161)
     * 	at ch.qos.logback.classic.spi.LoggingEvent.getFormattedMessage(LoggingEvent.java:293)
     * 	at ch.qos.logback.classic.spi.LoggingEvent.prepareForDeferredProcessing(LoggingEvent.java:206)
     * 	at ch.qos.logback.core.OutputStreamAppender.subAppend(OutputStreamAppender.java:223)
     * 	at ch.qos.logback.core.OutputStreamAppender.append(OutputStreamAppender.java:102)
     * 	at ch.qos.logback.core.UnsynchronizedAppenderBase.doAppend(UnsynchronizedAppenderBase.java:84)
     * 	at ch.qos.logback.core.spi.AppenderAttachableImpl.appendLoopOnAppenders(AppenderAttachableImpl.java:51)
     * 	at ch.qos.logback.classic.Logger.appendLoopOnAppenders(Logger.java:270)
     * 	at ch.qos.logback.classic.Logger.callAppenders(Logger.java:257)
     * 	at ch.qos.logback.classic.Logger.buildLoggingEventAndAppend(Logger.java:421)
     * 	at ch.qos.logback.classic.Logger.filterAndLog_1(Logger.java:398)
     * 	at ch.qos.logback.classic.Logger.info(Logger.java:583)
     * 	at com.moon.moon_thread.juc.Map.HashMapTest.lambda$main$0(HashMapTest.java:23)
     * 	at java.lang.Thread.run(Thread.java:748)
     * @param args
     */
    public static void main(String[] args) {
        Map map = new HashMap();
        for (int i = 0; i < 3000; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,5),UUID.randomUUID().toString().substring(0,5));
                log.info("{}",map);
            }).start();
        }
    }
}
