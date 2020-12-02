package com.moon.moon_main;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MoonMainApplicationTests {

    @Test
    void contextLoads() {

        int[] a = {3,2,4,6,2,3,5,3,5,7,4,9,11,5,23,22};
        for (int i=0;i<a.length-1;i++) {
            for (int k=i+1;k<a.length;k++) {
                if (a[i]>a[k]) {
                   int temp=a[k];
                   a[k] = a[i];
                   a[i] = temp;
                }
            }
        }
        log.info("{}",a);
    }


    @Test
    void contextLoad() {

        int[] a = {3,2,4,6,2,3,5,3,5,7,4,9,11,5,23,22};
        for (int i=0;i<a.length-1;i++) {
            for (int k=0;k<a.length-1;k++) {
                if (a[k]>a[k+1]) {
                    int temp=a[k];
                    a[k] = a[k+1];
                    a[k+1] = temp;
                }
            }
        }
        log.info("{}",a);
    }

}
