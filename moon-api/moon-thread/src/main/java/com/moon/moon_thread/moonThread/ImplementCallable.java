package com.moon.moon_thread.moonThread;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName ImplementCallable
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/21
 * @Version V1.0
 **/
@Slf4j
public class ImplementCallable implements Callable {

    @Override
    public Map<String,Object> call() throws Exception {
        Map map = new HashMap(1);
        map.put("moon","moon");
        return map;
    }

}
