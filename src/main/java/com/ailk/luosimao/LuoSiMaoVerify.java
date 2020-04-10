package com.ailk.luosimao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LuoSiMaoVerify {

    private static final Logger LOGGER = LoggerFactory.getLogger(LuoSiMaoVerify.class);


    public Boolean verify(String dataResp)
    {
        HttpClient httpclient = new HttpClient();
        //PostMethod post = new PostMethod(SpringUtil.getProperty("api.url"));
        PostMethod post = new PostMethod("https://captcha.luosimao.com/api/site_verify");
        post.setRequestHeader("Accept", "application/json");
        post.getParams().setParameter("http.protocol.content-charset", "utf-8");
        //post.addParameter("api_key", SpringUtil.getProperty("api.key"));
        post.addParameter("api_key", "345fc6add0ab1ff9a6fc97e2f6bbea0f");
        post.addParameter("response", dataResp);
        String info = "";
        try
        {
            httpclient.executeMethod(post);
            info = new String(post.getResponseBody(), "utf-8");
            LOGGER.info("人机验证返回信息：" + info);
            JSONObject responseJson = JSON.parseObject(info);
            String res = responseJson.getString("res");
            if ("success".equals(res)) {
                return Boolean.valueOf(true);
            }
            if ("failed".equals(res))
            {
                String error = responseJson.getString("error");
                if ("-10".equals(error)) {
                    LOGGER.error("API KEY 为空");
                } else if ("-11".equals(error)) {
                    LOGGER.error("response为空");
                } else if ("-2x".equals(error)) {
                    LOGGER.error("response错误");
                } else if ("-40".equals(error)) {
                    LOGGER.error("API_KEY使用错误，请确认使用了正确的KEY，注意前端和后端使用的KEY不同");
                }
                return Boolean.valueOf(false);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(false);
    }

}
