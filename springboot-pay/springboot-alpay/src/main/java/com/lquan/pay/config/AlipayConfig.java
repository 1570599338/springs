package com.lquan.pay.config;

import java.io.FileWriter;
import java.io.IOException;



    public class AlipayConfig {

        // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
        public static String app_id = "2016080100140889";

        // 商户私钥，您的PKCS8格式RSA2私钥
       // public static String merchant_private_key = "";
        public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCTMPoxZEJng+9D8ZmJHEVo59HkMOs/hKB+gv7j0pFigJ4kVjRQZNt814Xf+EooP14fmPLapdt3yzctv9kEzgiYqHw+ZxzvtzbiXC8Hp1vNDceVwyILcCcXiRqKQxxt+VwNSKx+yj+FKoHn0jdqnHfDm0PThkziIUQ/JlPjYyAvLLg5IMy0G93P/1vQOytbc2KfFTl7T1UxZwsoms/CgWLLP6ObEdC87LvOnU3/+sOMbfsb8DLyTqft+JKumkobuiX2ES4dcMNPuQDBEZKiyX2ZBQiUh+YNIf9kDGRKEQ90/FJVLhXfcywENE5IF7jtjKycjmyC1kbyoaXuaGTBp0ojAgMBAAECggEAafzPe7ddFZrsNDmJPDCuTk73VWBgVTmUM+Tx02zxoUNKHJIyU118qtWqoc7w3zBZ/1isLwNVGFqtXfUSOSJ/ECXqaSjorjh4feCxQMqjEPGGMPH01tWoYIsqIDsZApuXTD1zcE0EFki4iAxYOR14I9LusSa4v/ACa5KWv1rGdxCd36+sdMMTYF8bA8eV2KIs78qrjQybwQHuYAYsorx726pRwgsVWgom30khbiq7hKlKlP0fjMKI7BkQlM4vYYFtv5sXYt9PqSifs9qkS3/GhmT9fq0436zmRc4EBBgsMpgkzKLrYoMxO7Z94Oq7UqrXU9scqkJaGybQSvEH7BlzGQKBgQDHsx6ZA4IeAvz23F536UzXDQM/4uwzyqqpX6bpKvma+yyZo18mGjIAyOWxGXz47LoZmqAxWEdYqW31AfoGJxKA6SF9YctyE0uI0HLhOkCnGcuw3L7VyX1oDRcbGncTTL7iJfCS4Gbt6gFHZyPrSyNWWB5AMQmOpaMqRaVsVZx6zQKBgQC8sC7j7VxHzXkoFl2jheWGvL+71JcjhOCnwPmw2Wnas3UxOuPQENw31Tmq7r86CRXL6b2mDdM5CJvXXgyzNVoD1lTcu8Lmrif+jCKYZkAUsOKJQ5rTRjA5kDsyHodcNZVDVA9Gvbg904FbdDhzzFVJfmCwIkMsTnx/dTgbqRy4rwKBgQCWls/f+vFHyGERlqP2MIutLzbgGjKb65w+FM88zRdkczvyr2u0w9QpG1V58wp2e6zqWduq2jMS/NDaDR+JPDWL2EFU10YfQ8WV6fp3NQJEAAPF3vBZLpPOvvBJk+9vMlRPHOUJHQcBKZDFU1WWvRZsqg5FwbS/SNB9s/9GbliNkQKBgAa6faGRGEZTNGvSiFpJbwrj9i5bgVw548z3m6/LwPOUjKxJvk/wGfo/t0O6KcWHB2jzF9kxCwQwo2YFq4xEbcZPQU1xwJx7P1/bXWxz0Psr55gfegjoqtWSqBm8bvVBz+XLvJO4Nja2MRmyxkSS18O8JvSA9EZDMjtVUb/iwuxvAoGADmgFC/vhOl6+QTryzjZ+LBLxaYZGUCOAswZSG3p/CgaFxG0+G579utFXH17c7dNm4/N45pEFcs2BqjB1F6REkL/fbGFlPo+CYZyLsn5jGGeHZ9y29Tv0bpOa4qx5fdRN4DCFDEQkJsAFD2Wjr2VhAqG7KbkOBJG0CFm0QG+rga8=";

        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
       // public static String alipay_public_key = "";
        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp0Cu77m+zJeqn6NFj+YnDw5KRZnUFxkeWbCnb+RLQk2u7rbwQci1JI/8pJ++TQYckEeYjWaG62Pi4W0AxdhHt+Pert5RR8bMExMle3obkU19HcDu7aCC1cMPu3RS6ahuo2dtcOk2kv6r8TQLTPn8PlQNfJPu6yQa/1kbRUUwlYANMJrRq+hnsaHVb5J2Y9uKm8eLPZjqDjZ2zVgOmEwAyJsAvaFHNDnwUkCUagfUrTcHYvCF8huMzh/NE9EUWgwD0LfLTEOE0XZNmyYdw4VpmKr27Sk4rN1NG9falZKscdqJ2AY0pdY04l4qvPA6uTaRMRepu63WmeF7O+oy++GFBwIDAQAB";

        // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
       // public static String notify_url = "";
        public static String notify_url = "http://127.0.0.1:8080/notify_url.jsp";


        // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        // 即支付成功之后，需要跳转到的页面，一般为网站的首页
        public static String return_url = "http://www.baidu.com";
       // public static String return_url = "http://127.0.0.1:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";


        // 签名方式
        public static String sign_type = "RSA2";

        // 字符编码格式
        public static String charset = "utf-8";

        // 支付宝网关
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

        // 日志存储路径
        public static String log_path = "C:\\";


        /**
         * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
         * @param sWord 要写入日志里的文本内容
         */
        public static void logResult(String sWord) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
                writer.write(sWord);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


}
