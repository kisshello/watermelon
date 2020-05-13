package com.ailk.base;

/**
 * @description: 自定义异常（使用枚举）
 * @author: wanghk3
 * @time: 2020/5/13 10:19
 */
public class CommonException extends RuntimeException implements java.io.Serializable {

    private static final long serialVersionUID = 43999L;

    /** 模板异常 */
    private CExceptionEnums cExceptionEnums;

    /** 自定义异常信息 */
    private String errorDetail;

    /**
     * 带自定义异常信息的构造方法
     * @param cExceptionEnums
     * @param errorDetail
     */
    public CommonException(CExceptionEnums cExceptionEnums, String errorDetail){
        this.cExceptionEnums = cExceptionEnums;
        this.errorDetail = errorDetail;
    }

    /**
     * 模版异常的构造方法
     * @param cExceptionEnums
     */
    public CommonException(CExceptionEnums cExceptionEnums){
        super(cExceptionEnums.getEmsg());
        this.cExceptionEnums = cExceptionEnums;
    }

    public CExceptionEnums getcExceptionEnums(  ){
        return cExceptionEnums;
    }

    public String getErrorDetail(){
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail){
        this.errorDetail = errorDetail;
    }


    /**
     * 使用方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            if(true){
                //使用模板异常
                throw new CommonException(CExceptionEnums.WEIXIN_CALLBACK_EXCEPTION);
            }
            if(false){
                //也可以自定义模板信息
                throw new CommonException(CExceptionEnums.WEIXIN_CALLBACK_EXCEPTION,"自定义msg信息");
            }
        }catch (CommonException e){
            //捕获自定义异常
            e.printStackTrace();
            System.out.println(e.toString());
            CExceptionEnums cExceptionEnums = e.getcExceptionEnums();
            //此处逻辑信息，若无自定义信息，则使用enums中的msg，如有，则使用自定义异常信息
            if(null!=e.getErrorDetail()){
                //如果自定义信息不是null，就使用自定义信息
                String msg = e.getErrorDetail();
            }
        }
    }

}