package com.ailk.alipay.two;

public class AlipayConfig {

    // 1.商户appid
    public static String APPID = "2021001139688821";

    //2.私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChFRB3nrFAflGgSknCLuoUvJLNxTGLRMZMxdNyp1TFDeNzdH8ihZVQyizVz4UbUNTkjQzIQ7Cz595441XN7AieAZG28wrVO4B26b8jOOdYRjargak4EazrUd3rTt/7sjZkyoaaBu8N00HyC+GUHBArsEs8C6mnC8bAANSaWpukuQOUHkrWLE70z4ckj3jF7zKvFAx2VavxU0ySnItur2R2Hy8M7kDEEVPWh83be5hAIZe2kHtqARgqD0cJmGtEkBavi5sYLK+ysLFmYP+LqzVZ1Pn7VidP4XAv/GrVS+K1Csw7DabOv66Cxg/TN2m6TQlpwDH8WPJRtn3dRb0PrBOVAgMBAAECggEAYc+7nxcyhHnvsMhLP2ljZFIZRm+OJQYO74FUYxNuavWC/pFnvZulzlfln7MSHUMY8usfLt/DhYqvUXKhoJfJp8BGLfQoyNAHsq0/DfE4sSZ5fe0OxugcuwuMGJ1dbqWJV+yOjSrWr+tu6L4ELP5ZZ132YTCnxLJm7iHS9yM7zWo7AA88+VcRtiksJTdU3aFtzqu4xZzEwPpWAjvcgYxGAkpLwqbFBoL6EBhvuwgrMYggnvFhp6zL8VJcJg63co0t/9TfjdWtXqdjg27b9r+NzNdsWPkeQ9HlfPe1xlt89683OW4LiRSS1L3e0FUDsXZFPKqAOXSznoVhmf5b9b3PgQKBgQD5f8je693vylJJQGox4l6Ak8A54dFnvxJfFFjHJt3nT5U5FuLlxDriSmkTRZQPiCjA6mzDHYShRAQkvIh/NaGvtIF3fMoo1DFACHa/t7FbkKzwpZ0e+uBZ1D1J1Po7ASFSOfMyjdBQJQ7WKf365zkU0iB2UJ33bShwhp3Q5+rX9QKBgQClR4Tva7R9BRhZ/ozFHexX6nczeKvaPzcpnLGIvaO6QpdUAu7ACKT2wR44xYwygylmiqotkKP9tqzzybicUEKtUzeV5aBTuZL6i20HbsaOoHkNU8H6sc4i4LiiHe9GCvLrtztYmpwjsgPouf8HHztOzwN1Km9DdjDdAvnkRJApIQKBgAEIHT2GvikyrfptkMLaC8f+VGoo2+PQ73ODMwbHy10cgCJ3TMLkd9XdtueEfyM9TeXWUlLQOW8tR9MbEHluMFf4qBxlYLSgg/+eyVbrnIkjZQOtu6OYJ/tXHFXE0rARxiB/6tiHq5fZP2F1VP6HnD3QzJ+Qn8aZJfSpKdfmTZtNAoGACzevbhCBT3rpDDKam0ZMpCrlrDikcUuZEtnvsrgsRJgAbVNFoQL1L0osIu5FdagxRyRiKHWIq8+aLXGjdfh8jgb33tSW7RfLQfX0kGyUTVnW3XCx2bH3q6ZU4avmcXqMwjLNdFYKAuIyIbl99Z3JCLBEK8+VfZ6n8lghXbzJjAECgYEAvFDFTamBRbYRQaG6+JwGxrI/l0MrZgdIl7eycjDAJS+FZgoXI8wfA0mlMLZthocRygZxzqh2b71VCZAxG4wDRbvjf6u5iPoRIX3KsdcfoAlJ5SeuBQW9NBUfFG/VQQNsZjk+kQEZGiGCH/uEaQ8zF+UDv/ivWJmli96AJLescS8=";

    // 3.支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoRUQd56xQH5RoEpJwi7qFLySzcUxi0TGTMXTcqdUxQ3jc3R/IoWVUMos1c+FG1DU5I0MyEOws+feeONVzewIngGRtvMK1TuAdum/IzjnWEY2q4GpOBGs61Hd607f+7I2ZMqGmgbvDdNB8gvhlBwQK7BLPAuppwvGwADUmlqbpLkDlB5K1ixO9M+HJI94xe8yrxQMdlWr8VNMkpyLbq9kdh8vDO5AxBFT1ofN23uYQCGXtpB7agEYKg9HCZhrRJAWr4ubGCyvsrCxZmD/i6s1WdT5+1YnT+FwL/xq1UvitQrMOw2mzr+ugsYP0zdpuk0JacAx/FjyUbZ93UW9D6wTlQIDAQAB";

    // 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "https://jk.hnkqwy.com/pmcs/wyZFBPayController/pay.htm";

    //5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://m.alipay.com";

    // 6.请求支付宝的网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";

    // 7.编码
    public static String CHARSET = "UTF-8";

    // 8.返回格式
    public static String FORMAT = "json";

    // 9.加密类型
    public static String SIGNTYPE = "RSA2";
}
