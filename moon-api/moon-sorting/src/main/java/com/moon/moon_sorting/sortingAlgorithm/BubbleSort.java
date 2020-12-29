package com.moon.moon_sorting.sortingAlgorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName BubbleSort
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/25
 * @Version V1.0
 **/
@Slf4j
public class BubbleSort {


    /**
     * 冒泡排序
     * 1、比较相邻的元素。如果后一个比前一大，就交换位置。
     * 2、最多比较的次数是：1+2+3+4+...+numbers.length-1
     **/
    public static void main(String[] args) {
        Integer[] list = new Integer[13];
        list[0] = 10;
        list[1] =4;
        list[2] =4;
        list[3] =6;
        list[4] =4;
        list[5] =6;
        list[6] =8;
        list[7] =7;
        list[8] =5;
        list[9] =3;
        list[10] =1;
        list[11] =0;
        list[12] =2;

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - i -1; j++ ) {
                if (list[j] < list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        };
        log.info("{}",list);

    }
}
