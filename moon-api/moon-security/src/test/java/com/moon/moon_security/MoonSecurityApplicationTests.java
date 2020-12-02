package com.moon.moon_security;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class MoonSecurityApplicationTests {

    @Test
    void contextLoads() {
        Map map =  new HashMap(1);
        map.put("depTime","2020-11-28 10:34:24");
        map.put("destTime","2020-11-27 10:24:04");
        Long time = DateUtil.between(DateUtil.parse(map.get("depTime").toString()),DateUtil.parse(map.get("destTime").toString()), DateUnit.SECOND);
        log.info("SDFSFS{}",time);
    }

}
