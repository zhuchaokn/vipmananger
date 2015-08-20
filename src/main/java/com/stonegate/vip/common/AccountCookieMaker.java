package com.stonegate.vip.common;

import com.stonegate.vip.bean.Account;

import javax.servlet.http.Cookie;

/**
 * @author chao.zhu created on 15/8/20 上午11:52
 * @version 1.0
 */
public class AccountCookieMaker {
    public static Cookie[] makeCookies(Account account) {
        Cookie timeCookie = new Cookie("_t", String.valueOf(System.currentTimeMillis()));
        String text = String.format("%s&%s&%s", account.getUserName(), account.getLoginIp());
        Cookie infoCookie = new Cookie("_v", encrpt(text));
        Cookie[] cookies = new Cookie[2];
        cookies[0] = timeCookie;
        cookies[1] = infoCookie;
        return cookies;
    }

    public static Account parseCookie(String text) {
        return null;
    }

    private static String encrpt(String text) {
        char[] origin = new StringBuilder(text).reverse().toString().toCharArray();
        int length = origin.length;
        char[] codes = new char[length];
        for (int i = 0; i < length; i++) {
            codes[i] = (char) (origin[i] + 7);
        }
        return String.valueOf(codes);
    }

    private static String decrpt(String text) {
        char[] codes = new StringBuilder(text).reverse().toString().toCharArray();
        int length = codes.length;
        char[] origin = new char[length];
        for (int i = 0; i < length; i++) {
            origin[i] = (char) (codes[i] - 7);
        }
        return String.valueOf(origin);
    }
}
