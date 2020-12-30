package com.moon.moon_thread;

import com.moon.moon_thread.moonThread.ImplementCallable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.*;

@SpringBootTest
@Slf4j
class MoonThreadApplicationTests {

    @Qualifier("taskExecutor")
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Test
    void contextLoads() {
        FutureTask<Map<String, Object>> future = new FutureTask<>(new ImplementCallable());
        new Thread(future).start();
        Object obj = null;
        try {
            obj = future.get(1000 * 10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        log.info("----------------------{}",obj.toString());
    }
}
