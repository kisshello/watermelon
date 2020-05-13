package com.ailk.base;
/**
 *
 * @description: 自定义异常枚举类
 * @author: wanghk3
 * @time: 2020/5/13
 */
public enum CExceptionEnums {

    WEIXIN_CALLBACK_EXCEPTION    ("0001","已经有其他线程执行完回调流程，本次所有对订单操作的流程回滚"),
    SERVER_FTP_DOWN_ERROR        ("0002","从ftp下载文件失败"),
    SERVER_ALIYUN_UPLOAD_ERROR    ("0003","上传阿里云失败"),
    SERVER_IMG_ERROR            ("0004","图片错误"),
    SERVER_DB_ERROR                ("0005","数据库错误"),
    SERVER_OTHER_ERROR            ("1099","其他异常");//枚举类如果写方法的话，此处需要写分号

    private String ecode;

    private String emsg;

    CExceptionEnums(String ecode, String emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public String getEcode() {
        return ecode;
    }

    public String getEmsg() {
        return emsg;
    }

    public static CExceptionEnums statOf(String ecode) {
        for (CExceptionEnums state : values())
            if (state.getEcode().equals(ecode))
                return state;
        return null;
    }

}
