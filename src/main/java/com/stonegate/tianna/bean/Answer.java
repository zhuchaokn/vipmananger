package com.stonegate.tianna.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chao.zhu created on 15/8/15 上午10:29
 * @version 1.0
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 7152292944570475601L;
    private int id;
    private String content;
    private int questionId;
    private Date createTime;
    private String provider = "anonymous";
    public static final Answer IDontKnow = new Answer("哎呀，不好意思，我不知道该怎么回答你啊。", 0, "default");

    public Answer() {
    }

    public Answer(String content, int questionId, String provider) {
        this.content = content;
        this.questionId = questionId;
        this.provider = provider;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
