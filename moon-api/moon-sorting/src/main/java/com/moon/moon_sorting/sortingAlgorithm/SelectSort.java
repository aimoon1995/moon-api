package com.moon.moon_sorting.sortingAlgorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SelectSort
 * @Description: TODO
 * @Author zyl
 * @Date 2020/12/25
 * @Version V1.0
 **/
@Slf4j
public class SelectSort {

    /**
     * 把最小的往前面放
     * 選擇一個值和後面所有的值比，把最小的和當前的值替換
     * @param args
     */
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
            int k = i;// 默認個和後面的比是最小的那個
            for (int j = i+1; j < list.length ; j++ ) {
                if (list[k] > list[j]) {
                   k = j;
                }
            };
            // 交換k和i的位置
            int temp = list[k];
            list[k] =list[i];
            list[i] = temp;
        };
        log.info("{}",list);
    }
}
