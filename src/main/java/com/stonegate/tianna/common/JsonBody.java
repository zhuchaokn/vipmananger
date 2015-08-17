package com.stonegate.tianna.common;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author chao.zhu created on 15/8/7 上午6:44
 * @version 1.0
 */
public class JsonBody<T> implements Serializable{

    private static final long serialVersionUID = 1246386474088999897L;
    private boolean ret;
    private T data;
    private String msg;

    private JsonBody(boolean ret, T data, String msg) {
        this.ret = ret;
        this.data = data;
        this.msg = msg;
    }

    public static <T> JsonBody<T> success(T data) {
        return new JsonBody<T>(true, data, null);
    }

    public static <T> JsonBody<T> fail(String msg) {
        return new JsonBody<T>(false, null, msg);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
