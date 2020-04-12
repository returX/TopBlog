package com.topblog.myblog.util;

/**
 * @Author: RETURN
 * @Date: 2020/4/12 17:35
 */
public class InfoUtil {

    /**
     *提取html中的文本
     */
    public static String htmlToText(String html){
        int length = html.length()>300?300:html.length();
        String htmlRegex = "<[^>]+>";
        String subHtml = html.substring(0,length);
        String str = subHtml.replaceAll(htmlRegex,"").concat("...");
        return str;
    }
}
