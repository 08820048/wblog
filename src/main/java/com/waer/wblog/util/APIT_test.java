package com.waer.wblog.util;

import com.alibaba.fastjson.JSON;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("all")
/**
 * @author: Tisox
 * @date: 2022/6/10 9:46
 * @description:
 * @blog:www.waer.ltd
 */
public class APIT_test {
    public static final String KEY = "4ee21d2553bef8ce2ea87f2a174e36d0";
    public static void main(String[] args) {
        /*测试网易云热评API*/

        String httpUrl = "http://api.tianapi.com/hotreview/index?key=" + KEY;
        String jsonResult = request(httpUrl);
        JSON.parseObject(jsonResult, String.class);
        //String jsonResult = RestRequest(httpUrl);
        System.out.println(jsonResult);
    }

    /**
     * 请求体主要方法
     * @param httpUrl 请求URL
     * @param httpArg 请求参数
     * @return 返回结果
     */
    public static String request(String httpUrl){
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String RestRequest(String URL){
        RestTemplate template = new RestTemplate();
        String forObject = template.getForObject(URL, String.class);
        String res = JSON.toJSONString(forObject);
        return res;
    }
}
