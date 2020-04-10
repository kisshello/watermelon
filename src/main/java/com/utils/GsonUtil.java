package com.utils;

import com.google.gson.Gson;

import java.util.Map;

public class GsonUtil {

    //参考链接：https://blog.csdn.net/qq_33210042/article/details/100351938

    /**
     * Gson 里面有2个方法 toJson 和fromJson
     *
     * toJson 是把字符串转成  json 形式
     *
     * fromJson 是把json 形式转成字符串形式
     */

    /**
     * 将map转化为json格式
     * @param map
     * @return
     */
    public static String toJson(Map map){
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

    class PeopleBean {


        /**
         * name : 小牧
         * age : 23
         * hobby : 游戏
         */

        private String name;
        private String age;
        private String hobby;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }
    }

    public static PeopleBean fromJson(){
        String result = "{\"name\":\"小牧\",\"age\":\"23\",\"hobby\":\"游戏\"}";
        PeopleBean bean = new Gson().fromJson(result, PeopleBean.class);
        System.out.print(bean.getName());
        System.out.print(bean.getAge());
        System.out.print(bean.getHobby());
        return bean;
    }

}
