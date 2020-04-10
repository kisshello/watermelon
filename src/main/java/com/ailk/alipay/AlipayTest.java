package com.ailk.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class AlipayTest {

    @Test
    public void doPay1() throws Exception {
        //先保存一条支付记录
        //开发者appid
        String appid = "2021001139688821";
        //客户私钥
        String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChFRB3nrFAflGgSknCLuoUvJLNxTGLRMZMxdNyp1TFDeNzdH8ihZVQyizVz4UbUNTkjQzIQ7Cz595441XN7AieAZG28wrVO4B26b8jOOdYRjargak4EazrUd3rTt/7sjZkyoaaBu8N00HyC+GUHBArsEs8C6mnC8bAANSaWpukuQOUHkrWLE70z4ckj3jF7zKvFAx2VavxU0ySnItur2R2Hy8M7kDEEVPWh83be5hAIZe2kHtqARgqD0cJmGtEkBavi5sYLK+ysLFmYP+LqzVZ1Pn7VidP4XAv/GrVS+K1Csw7DabOv66Cxg/TN2m6TQlpwDH8WPJRtn3dRb0PrBOVAgMBAAECggEAYc+7nxcyhHnvsMhLP2ljZFIZRm+OJQYO74FUYxNuavWC/pFnvZulzlfln7MSHUMY8usfLt/DhYqvUXKhoJfJp8BGLfQoyNAHsq0/DfE4sSZ5fe0OxugcuwuMGJ1dbqWJV+yOjSrWr+tu6L4ELP5ZZ132YTCnxLJm7iHS9yM7zWo7AA88+VcRtiksJTdU3aFtzqu4xZzEwPpWAjvcgYxGAkpLwqbFBoL6EBhvuwgrMYggnvFhp6zL8VJcJg63co0t/9TfjdWtXqdjg27b9r+NzNdsWPkeQ9HlfPe1xlt89683OW4LiRSS1L3e0FUDsXZFPKqAOXSznoVhmf5b9b3PgQKBgQD5f8je693vylJJQGox4l6Ak8A54dFnvxJfFFjHJt3nT5U5FuLlxDriSmkTRZQPiCjA6mzDHYShRAQkvIh/NaGvtIF3fMoo1DFACHa/t7FbkKzwpZ0e+uBZ1D1J1Po7ASFSOfMyjdBQJQ7WKf365zkU0iB2UJ33bShwhp3Q5+rX9QKBgQClR4Tva7R9BRhZ/ozFHexX6nczeKvaPzcpnLGIvaO6QpdUAu7ACKT2wR44xYwygylmiqotkKP9tqzzybicUEKtUzeV5aBTuZL6i20HbsaOoHkNU8H6sc4i4LiiHe9GCvLrtztYmpwjsgPouf8HHztOzwN1Km9DdjDdAvnkRJApIQKBgAEIHT2GvikyrfptkMLaC8f+VGoo2+PQ73ODMwbHy10cgCJ3TMLkd9XdtueEfyM9TeXWUlLQOW8tR9MbEHluMFf4qBxlYLSgg/+eyVbrnIkjZQOtu6OYJ/tXHFXE0rARxiB/6tiHq5fZP2F1VP6HnD3QzJ+Qn8aZJfSpKdfmTZtNAoGACzevbhCBT3rpDDKam0ZMpCrlrDikcUuZEtnvsrgsRJgAbVNFoQL1L0osIu5FdagxRyRiKHWIq8+aLXGjdfh8jgb33tSW7RfLQfX0kGyUTVnW3XCx2bH3q6ZU4avmcXqMwjLNdFYKAuIyIbl99Z3JCLBEK8+VfZ6n8lghXbzJjAECgYEAvFDFTamBRbYRQaG6+JwGxrI/l0MrZgdIl7eycjDAJS+FZgoXI8wfA0mlMLZthocRygZxzqh2b71VCZAxG4wDRbvjf6u5iPoRIX3KsdcfoAlJ5SeuBQW9NBUfFG/VQQNsZjk+kQEZGiGCH/uEaQ8zF+UDv/ivWJmli96AJLescS8=";
        //客户公钥
        String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoRUQd56xQH5RoEpJwi7qFLySzcUxi0TGTMXTcqdUxQ3jc3R/IoWVUMos1c+FG1DU5I0MyEOws+feeONVzewIngGRtvMK1TuAdum/IzjnWEY2q4GpOBGs61Hd607f+7I2ZMqGmgbvDdNB8gvhlBwQK7BLPAuppwvGwADUmlqbpLkDlB5K1ixO9M+HJI94xe8yrxQMdlWr8VNMkpyLbq9kdh8vDO5AxBFT1ofN23uYQCGXtpB7agEYKg9HCZhrRJAWr4ubGCyvsrCxZmD/i6s1WdT5+1YnT+FwL/xq1UvitQrMOw2mzr+ugsYP0zdpuk0JacAx/FjyUbZ93UW9D6wTlQIDAQAB";
        //回调接口地址
        String alinotify_url = "https://jk.hnkqwy.com/pmcs/wyZFBPayController/pay.htm";
        //设置请求的参数
        Map<String, String> alimap = new HashMap<String, String>();
        alimap.put("out_trade_no", "123456");
        alimap.put("total_amount", String.valueOf(0.01));//订单总金额  为了测试目前先写死为0.01
        alimap.put("subject", "会议室预付定金");//商品描述
        alimap.put("timeout_express", "30m");//订单失效时间
        //将公共回传参数进行urlencode，支付宝要求
        String differencepay = URLEncoder.encode("会议支付", "UTF-8");
        alimap.put("passback_params", differencepay);
        //支付宝客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",appid,private_key,"json","utf-8",alipay_public_key,"RSA");
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
        ali_request.setNotifyUrl(alinotify_url);
        ali_request.setApiVersion("1.0");
        ali_request.setBizContent("{" +
                "\"out_trade_no\":\"20150320010101001\"," +
                "\"trade_no\":\"2014112611001004680073956707\"," +
                "\"org_pid\":\"2088101117952222\"" +
                "  }");

        //获取ali的响应数据
        AlipayTradeAppPayResponse aliresponse = alipayClient.sdkExecute(ali_request);
        System.out.println("响应body：" + aliresponse.getBody());
        //验证阿里的响应是否成功
        if (aliresponse.isSuccess()) {
            System.out.println("成功啦！");
        } else {
            System.out.println("不行啦");
            return;
        }
    }
}
