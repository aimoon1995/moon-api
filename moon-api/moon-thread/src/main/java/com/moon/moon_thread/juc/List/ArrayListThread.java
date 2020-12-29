package com.moon.moon_thread.juc.List;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName ArrayListThread
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/29
 * @Version V1.0
 **/
@Slf4j
public class ArrayListThread {

   /*
   10:17:10.425 [540] INFO com.moon.moon_thread.juc.List.ArrayListThread - [FAILED toString()]
java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at java.util.AbstractCollection.toString(AbstractCollection.java:461)
	at org.slf4j.helpers.MessageFormatter.safeObjectAppend(MessageFormatter.java:277)
	at org.slf4j.helpers.MessageFormatter.deeplyAppendParameter(MessageFormatter.java:249)
	at org.slf4j.helpers.MessageFormatter.arrayFormat(MessageFormatter.java:211)
	at org.slf4j.helpers.MessageFormatter.arrayFormat(MessageFormatter.java:161)
	at ch.qos.logback.classic.spi.LoggingEvent.getFormattedMessage(LoggingEvent.java:293)
	at ch.qos.logback.classic.spi.LoggingEvent.prepareForDeferredProcessing(LoggingEvent.java:206)
	at ch.qos.logback.core.OutputStreamAppender.subAppend(OutputStreamAppender.java:223)
	at ch.qos.logback.core.OutputStreamAppender.append(OutputStreamAppender.java:102)
	at ch.qos.logback.core.UnsynchronizedAppenderBase.doAppend(UnsynchronizedAppenderBase.java:84)
	at ch.qos.logback.core.spi.AppenderAttachableImpl.appendLoopOnAppenders(AppenderAttachableImpl.java:51)
	at ch.qos.logback.classic.Logger.appendLoopOnAppenders(Logger.java:270)
	at ch.qos.logback.classic.Logger.callAppenders(Logger.java:257)
	at ch.qos.logback.classic.Logger.buildLoggingEventAndAppend(Logger.java:421)
	at ch.qos.logback.classic.Logger.filterAndLog_1(Logger.java:398)
	at ch.qos.logback.classic.Logger.info(Logger.java:583)
	at com.moon.moon_thread.juc.List.ArrayListThread.lambda$main$0(ArrayListThread.java:25)
	at java.lang.Thread.run(Thread.java:748)

    */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                log.info("{}",list);
            },i+"").start();
        }
    }
}
