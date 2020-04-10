package com.ailk.alipay.two;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 参考链接：https://blog.csdn.net/ouyzc/article/details/79551714
 */
public class GenerateSign {

    private static final Logger logger = LoggerFactory.getLogger(GenerateSign.class);

    @Test
    public void getAliPayOrderStr() {

        OrderTest orderTest = new OrderTest();
        orderTest.setOutTradeNo("123456789012");
        orderTest.setId("123654987");
        orderTest.setTotalAmount("0.01");
        orderTest.setBody("测试哟");
        orderTest.setSubjecy("测试jecy");
        //最终返回加签之后的，app需要传给支付宝app的订单信息字符串
        String orderString = "";
        logger.info("==================支付宝下单,商户订单号为：" + orderTest.getOutTradeNo());

        //创建商户支付宝订单(因为需要记录每次支付宝支付的记录信息，单独存一个表跟商户订单表关联，以便以后查证)
        AlipaymentOrder alipaymentOrder = new AlipaymentOrder();
        alipaymentOrder.setClubOrderId(orderTest.getId().toString());//商家订单主键
        alipaymentOrder.setOutTradeNo(orderTest.getOutTradeNo());//商户订单号
        alipaymentOrder.setTradeStatus((byte) 0);//交易状态
        alipaymentOrder.setTotalAmount(Double.parseDouble(orderTest.getTotalAmount()));//订单金额
        alipaymentOrder.setReceiptAmount(0.00);//实收金额
        alipaymentOrder.setInvoiceAmount(0.00);//开票金额
        alipaymentOrder.setBuyerPayAmount(0.00);//付款金额
        alipaymentOrder.setRefundFee(0.00);    //总退款金额

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                    AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                    AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

            //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
            AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();

            //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

            //业务参数传入,可以传很多，参考API
            //model.setPassbackParams(URLEncoder.encode(request.getBody().toString())); //公用参数（附加数据）
            model.setBody(orderTest.getBody());                       //对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
            model.setSubject(orderTest.getSubjecy());                 //商品名称
            model.setOutTradeNo(orderTest.getOutTradeNo());           //商户订单号(自动生成)
            // model.setTimeoutExpress("30m");     			  //交易超时时间
            model.setTotalAmount(orderTest.getTotalAmount());         //支付金额
            model.setProductCode("QUICK_MSECURITY_PAY");              //销售产品码（固定值）
            ali_request.setBizModel(model);
            logger.info("====================异步通知的地址为：" + alipaymentOrder.getNotifyUrl());
            ali_request.setNotifyUrl(AlipayConfig.notify_url);        //异步回调地址（后台）
            ali_request.setReturnUrl(AlipayConfig.return_url);        //同步回调地址（APP）

            // 这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request); //返回支付宝订单信息(预处理)
            orderString = alipayTradeAppPayResponse.getBody();//就是orderString 可以直接给APP请求，无需再做处理。
            //this.createAlipayMentOrder(alipaymentOrder);//创建新的商户支付宝订单

        } catch (AlipayApiException e) {
            e.printStackTrace();
            logger.info("与支付宝交互出错，未能生成订单，请检查代码！");
        }

        System.out.println("orderString:"+orderString);

    }
}
