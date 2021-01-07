package com.moon.moon_thread;

import com.moon.moon_thread.moonThread.ImplementCallable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootTest
@Slf4j
class MoonOneThreadApplicationTests {
    @Test
    void contextLoads() {

            String s ="  ";
            log.info("------------------------{}",s.trim().length());

    }
}
