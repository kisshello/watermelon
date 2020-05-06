package com.utils;

import java.util.UUID;

/**
 * @description: 文件上传的工具类
 * @author: wanghk3
 * @time: 2020/5/5 22:35
 */
public class UploadUtils {

    /**
     * 传递一个文件名，返回一个唯一的文件名
     */
    public static String getUuidFileName(String fileName){
        //在java的API中有一个类UUID可以产生随机的字符串.aa.txt
        // UUID.randomUUID().toString();
        //获得文件的扩展名
        int idx = fileName.lastIndexOf(".");
        String extentions = fileName.substring(idx);
        return UUID.randomUUID().toString().replace("-","")+extentions;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-",""));
        String s = getUuidFileName("aa.txt");
        System.out.println(s);
    }

}