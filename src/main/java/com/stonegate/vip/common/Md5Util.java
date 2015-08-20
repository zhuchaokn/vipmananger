package com.stonegate.vip.common;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * @author chao.zhu created on 15/8/17 下午4:20
 * @version 1.0
 */
public class Md5Util {
    private static String salt = "fade324!`afd%8(fdandfsadfjaksfja)fdsala+@";

    public static String md5(String text) {
        return Hashing.md5().newHasher().putString(text, Charsets.UTF_8).hash().toString();
    }

    public static String md5WithSalt(String text) {
        if (text.length() < 32) {
            return md5(text + salt.substring(0, 32 - text.length()));
        }
        return md5(text);
    }
}
