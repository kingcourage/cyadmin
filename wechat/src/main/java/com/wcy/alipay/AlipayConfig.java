package com.wcy.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016080400167667";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCZZp6G0gfHDoHpDJXketaCtneIlOkrbyiUCTuyZ/+81zKfo4NS+sLMPh6Co2CA/glGLDdSL71jR4h6K95px/RI7RACRr5NcBzQkS+rfw6loxbRzmlGDAEwEhfmcM6mI+lKW9aRfcXDhV/n8ZwDnv5nN/oNd4+kx5Q9zdGgyzlbcQHdQIwplEXV8vDJBRb804Rj0c9Dsx9ets01K9Vw7BESBl9X5o7S7SPp6fiimhdlt98EjzqMfQCtujqpcHv1jPClHFtcL3IRzQZyULowgd2ter2Pi9eV3bQU1PH3MrlaFPyaD8SQNYi0U9uuG6/PQH83lsRJ1OYwjf4n3jBw0katAgMBAAECggEAdanV/PnLR28kTHr/2mIyec61/0ihVVSNHoe6h4zoB5RVW0fTqml306vuQSxKEIdK2818nYjKzwUGdReDIUZjZTCZL/XNcJ6HK5/Bndz2giyHi2S1MSpyGso2FOcAS0WOYx/whGahs+hw+PtFPS3OW6P/JCdKQg1n8sQVgC2BkFX4hgrJ7TyrqF97LNpqTdM1GLrNFg2qPN8XvOOfQ3QDWcqRw7iwGoWxT/axGoy7IH/aATal6ExTqFtP7eJOZNtxgvlIRCUyiTPhT+L64H08gkDcfksZtUZyoW5qT3BmCBvXNaDkLcfEmYTpNrrJpHES7f04YAUbGoAmBOfzToH8LQKBgQDr1QS2q2XuZdHANmlRw1BzljK3ZPSj64cDwW16EJtBW2XZyxbizittL8wpb5pAlC1sNs6tt3r2HQ1DKmTm4bDBjr2FmfBnjsQWE1jFmwk1YQvAKyeLAu8K6A9xgEeVBhhObZkhvNCGBaxlVkyANsQd85rKCewgA/lGAP2B9BOSwwKBgQCmhPcZaazXokP+sF8pnSgD8dh84KPJCw56a42HPldte7Ijpfya2GLJ3JaXG6p5Nx+AUbQG3HuTkWOGYN7RI45rA9bq1bpqgq0jGC9dNs3q8rM03XXVO2UN2zKtpuRuu8ZgV0/jLXPRXTC234mO12a8B9rsuPPvvKOgucI2IvdJzwKBgGydp5YaStAJxRkp9kfaFOuneaRNsv7sMzrfk3RswZTQa5BroRbEreuT4AwVgo3LsT/t3jLUFqXTq5ALrn1H5QjAnTkzNS386wLf1jrstMkI8UiIl6XGrCHxz2sPEejo7bjxcV3AgKm5YzUpEgLbNmg1Ek2LVF1KdzxuqFN5/qnRAoGADdZiykPTzx920wVJAyZCGwHP4aCxO5WloFqrqh9uGHT8+qVidmOg4fFouincYrJH9dvUP/W2dy7PvGz0VyDDRvVMuLsGAK/XP2FVHkPdnLaKWcxFbHDBFwOuFGwX83O7KmpXAyPVygIaeDffMHWJ3foxIRbFfpiIaGTHVMRXFFUCgYEAk5u9wIuyDy/jyI/oLbD42Eo5RO62K1R1ILRWZAIhw/gjmhfFWhKIMUSGI0mkdZuPZyMftv8K6euezaQ5I4vtXRJXHOPwvb937KIcJw0rWofvQAxhvQ15yo34HAFYT5/MGIaAV2ECnLNTkaC0sFi6yyNv23iiEhkP5pnw1AGuy9c=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtugyGH+d3jWBockGU+7Gndju5XP5PeQ5kdcFWZb+QwBsltkRnyQQ6G79NokcSgByR53pgGZGuIYS2BR81jGpIOOlCnMXIMoHll3tkhv2vWDwSSjRIonOTF7nNf7yP7Lq0DYXOdjwfl3INHUNtBVWa9F3lAbqUQ28rGlBzKmiFQ2IXNEsHtcvYHYz5uAvj4jLbH3FS4vlGqvr7Qfjv5R80dvwpr1ZUKwtvvHpM7U3T1tZGQUYqGl4LszxtAAPwh3YCIQD0NdBkRZfIHXmIEgLpXWADadvDYWGpil2EoGdtGFggn1Vu65tZihpBCo/lIMTnENi5ASWrIWdtzusiV8e9wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost/alipay/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost/alipay/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

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

