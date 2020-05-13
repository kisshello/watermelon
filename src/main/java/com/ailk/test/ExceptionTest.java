package com.ailk.test;

import com.ailk.base.CExceptionEnums;
import com.ailk.base.CommonException;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/5/13 16:23
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            throw new CommonException(CExceptionEnums.WEIXIN_CALLBACK_EXCEPTION);
        }catch (CommonException e){
            e.printStackTrace();
            //上面这里就可以打印出对应的错误的枚举类里的具体信息，比如此处打印的是"已经有其他线程执行完回调流程，本次所有对订单操作的流程回滚"
        }
    }
}