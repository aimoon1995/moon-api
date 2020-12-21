package com.moon.moon_thread.config;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * @ClassName AsyncConfig
 * @Description: TODO
 * @Author zyl
 * @Date 2020/9/11
 * @Version V1.0
 **/
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
 Logger logger = LoggerFactory.getLogger(AsyncConfig.class);


    @Value("${threadPool.corePoolSize}")
    private Integer corePoolSize;

    @Value("${threadPool.maxPoolSize}")
    private Integer maxPoolSize;

    @Value("${threadPool.keepAliveSeconds}")
    private Integer keepAliveSeconds;

    @Value("${threadPool.queueCapacity}")
    private Integer queueCapacity;

    @Value("${threadPool.awaitTerminationSeconds}")
    private Integer awaitTerminationSeconds;



    @Override
    @Bean("taskExecutor")
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        taskExecutor.setThreadNamePrefix("taskExecutor--");
        taskExecutor.setWaitForTasksToCompleteOnShutdown(false);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        taskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex , Method method , Object... params) {
                logger.error("线程池执行任务发生未知异常.{}", ex.getCause());
                ex.printStackTrace();
            }
        };
    }
}
