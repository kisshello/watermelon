package com.ailk.play;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/6/4 16:47
 */
public class ArraysPlay {
    public static void main(String[] args) {
        //数组静态初始化
        int[] arrays = new int[]{1,2,3,4,5};
        int[] arrays1 = {1,2,3,4,5};
        //数组动态初始化
        int[] arrays2 = new int[10];

        System.out.print("下面是array:");
        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]);
        }
        System.out.println();
        System.out.print("下面是arrays1:");
        for (int i=0;i<arrays1.length;i++){
            System.out.print(arrays1[i]);
        }
        System.out.println();
        System.out.print("下面是arrays2:");
        for (int i=0;i<arrays2.length;i++){
            System.out.print(arrays2[i]);
        }
        System.out.println();
    }
}