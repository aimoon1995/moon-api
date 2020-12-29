package com.moon.moon_thread.juc.Set;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @ClassName SetTest
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
@Slf4j
public class SetTest {
    /**
     * java.util.ConcurrentModificationException13:10:48.370 [34] INFO com.moon.moon_thread.juc.Set.SetTest - [FAILED toString()]
     *
     * 	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1437)
     * 	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
     * 	at java.util.AbstractCollection.toString(AbstractCollection.java:461)
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
     * 	at com.moon.moon_thread.juc.Set.SetTest.lambda$main$0(SetTest.java:21)
     * 	at java.lang.Thread.run(Thread.java:748)
     * java.util.ConcurrentModificationException
     * @param args
     */
    public static void main(String[] args) {
        Set<String> list = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                log.info("{}",list);
            },i+"").start();
        }
    }
}
