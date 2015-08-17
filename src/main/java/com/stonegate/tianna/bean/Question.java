package com.stonegate.tianna.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chao.zhu created on 15/8/7 上午6:41
 * @version 1.0
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 6984855534061320900L;
    private int id;
    private String content;
    private String questioner = "anonymous";
    private Date createTime;
    private Date updateTime;

    public Question() {
    }

    public Question(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Question(String content, String questioner) {
        this.content = content;
        this.questioner = questioner;
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

    public String getQuestioner() {
        return questioner;
    }

    public void setQuestioner(String questioner) {
        this.questioner = questioner;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
