package com.stonegate.vip.common;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.stonegate.vip.bean.Account;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author chao.zhu created on 15/8/20 上午11:52
 * @version 1.0
 */
public class AccountCookieMaker {
    private static Splitter splitter = Splitter.on('&');

    public static Cookie[] makeCookies(Account account) {
        Cookie timeCookie = new Cookie("_t", String.valueOf(System.currentTimeMillis()));
        String text = String.format("%s&%s", account.getUserName(), account.getLoginIp());
        try {

            Cookie infoCookie = new Cookie("_v", encrpt(text));
            Cookie[] cookies = new Cookie[2];
            cookies[0] = timeCookie;
            cookies[1] = infoCookie;
            return cookies;
        } catch (Exception e) {
            return null;
        }
    }

    public static Account parseCookie(String text) {
        String origin = null;
        try {
            origin = decrpt(text);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        List<String> paramList = Lists.newArrayList(splitter.split(origin));
        Account account = new Account();
        account.setUserName(paramList.get(0));
        account.setLoginIp(paramList.get(1));
        return account;
    }

    private static String encrpt(String text) throws UnsupportedEncodingException {
        char[] origin = new StringBuilder(text).reverse().toString().toCharArray();
        int length = origin.length;
        char[] codes = new char[length];
        for (int i = 0; i < length; i++) {
            codes[i] = (char) (origin[i] + 7);
        }
        return URLEncoder.encode(String.valueOf(codes), Charsets.UTF_8.name());
    }

    private static String decrpt(String text) throws UnsupportedEncodingException {
        char[] codes = new StringBuilder(URLDecoder.decode(text, Charsets.UTF_8.name())).reverse().toString()
                .toCharArray();
        int length = codes.length;
        char[] origin = new char[length];
        for (int i = 0; i < length; i++) {
            origin[i] = (char) (codes[i] - 7);
        }
        return String.valueOf(origin);
    }
}
