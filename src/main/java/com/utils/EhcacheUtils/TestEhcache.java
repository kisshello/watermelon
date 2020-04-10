package com.utils.EhcacheUtils;

import com.ailk.base.Constants;
import com.utils.DateUtils;
import org.junit.Test;

public class TestEhcache {

    /**
     * 第一种，使用DataCache写入缓存和读取缓存
     */
    @Test
    public void testDataCache(){
        DataCache.getInstance().writeData("name","zhangsan");
        System.out.println(DataCache.getInstance().readData("name").toString());;
    }


    /**
     * 使用EHCacheUtil存入缓存，变量依次是：cache名称、缓存的key、缓存的value、缓存存活时间
     * 注：
     * @throws Exception
     */
    @Test
    public void testEhcache() throws Exception{
        String timesKey = "name";
        //新命名的cache，猜测使用的是chcache.xnl中的<defaultCache>
        EHCacheUtil.setValue("March", timesKey, "张三", DateUtils.getSecondsToDawn());
        System.out.println(EHCacheUtil.getValue("March","name").toString());
        //也可以使用老的cache
        EHCacheUtil.setValue(Constants.SMS_CACHE_CODE, timesKey, "123", DateUtils.getSecondsToDawn());
        System.out.println(EHCacheUtil.getValue(Constants.SMS_CACHE_CODE,"name").toString());
    }


}
